package com.cs3repo.moviesshows

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.ExtractorLink
import com.lagradost.cloudstream3.utils.newExtractorLink
import org.jsoup.nodes.Element

abstract class BaseMoviesShowsProvider : MainAPI() {
    override var mainUrl: String = ""
    override var name: String = "Movies & Shows"
    override val supportedTypes = setOf(TvType.Movie, TvType.TvSeries)
    override val hasMainPage = true
    override val mainPage = mainPageOf(MainPageData("Latest", mainUrl))

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse? {
        val doc = app.get(request.data).document
        val results = doc.select("div.film_list-item, div.movie-item, article.item, .post, .flw-item, .item").mapNotNull { it.toSearchResult() }
        return newHomePageResponse(request, results, false)
    }
    protected open val searchUrl: String = "/?s="

    protected open fun Element.toSearchResult(): SearchResponse? {
        val title = selectFirst("h3, h2, .title, .name, a.title")?.text()?.trim() ?: return null
        val href = fixUrl(selectFirst("a")?.attr("href") ?: return null)
        val poster = selectFirst("img")?.let { it.attr("data-src").ifEmpty { it.attr("src") } }
        return newMovieSearchResponse(title, href, TvType.Movie) { addPoster(poster) }
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val url = if (mainUrl.endsWith("/")) "${mainUrl}${searchUrl.trimStart('/')}$query" else "$mainUrl$searchUrl$query"
        val doc = app.get(url).document
        return doc.select("div.film_list-item, div.movie-item, article.item, .post").mapNotNull { it.toSearchResult() }
    }

    override suspend fun load(url: String): LoadResponse {
        val doc = app.get(url).document
        val title = doc.selectFirst("h1, .movie-title, .title, .entry-title")?.text()?.trim() ?: "Unknown"
        val poster = doc.selectFirst("img.poster, .poster img, .thumbnail img, img")?.let { it.attr("data-src").ifEmpty { it.attr("src") } }
        val description = doc.selectFirst(".description, .summary, .synopsis, .entry-content, p")?.text()?.trim()
        val tags = doc.select(".genres a, .tag a").map { it.text().trim() }
        val type = if (url.contains("tv") || url.contains("series")) TvType.TvSeries else TvType.Movie

        val episodes = if (type == TvType.TvSeries) {
            doc.select(".season-list li a, .episode-list a, .episodes a").map { episodeElement ->
                newEpisode(episodeElement.attr("href")) { name = episodeElement.text().trim() }
            }
        } else emptyList()

        return if (type == TvType.TvSeries) {
            newTvSeriesLoadResponse(title, url, type, episodes) {
                posterUrl = poster
                plot = description
                this.tags = tags
            }
        } else {
            newMovieLoadResponse(title, url, type, url) {
                posterUrl = poster
                plot = description
                this.tags = tags
            }
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        val doc = app.get(data).document
        doc.select("source, iframe, .play-link, .video-link, a[href*=.mp4], a[href*=.mkv]").forEach { element ->
            val link = element.attr("src").ifEmpty { element.attr("href") }
            if (link.isNotEmpty()) {
                callback(newExtractorLink(name, name, fixUrl(link)))
            }
        }
        return true
    }
}
