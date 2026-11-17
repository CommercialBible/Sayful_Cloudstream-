package com.cs3repo.anime

import com.lagradost.cloudstream3.*
import org.jsoup.nodes.Element

abstract class BaseAnimeProvider : MainAPI() {
    override var mainUrl: String = ""
    override var name: String = "Anime"
    override val supportedTypes = setOf(TvType.Anime)
    protected open val searchUrl: String = "/?s="

    protected open fun Element.toSearchResult(): SearchResponse? {
        val title = selectFirst("h3, h2, .title, .name, a.title")?.text()?.trim() ?: return null
        val href = fixUrl(selectFirst("a")?.attr("href") ?: return null)
        val poster = selectFirst("img")?.let { it.attr("data-src").ifEmpty { it.attr("src") } }
        return newAnimeSearchResponse(title, href, TvType.Anime) { addPoster(poster) }
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val url = if (mainUrl.endsWith("/")) "${mainUrl}${searchUrl.trimStart('/')}$query" else "$mainUrl$searchUrl$query"
        val doc = app.get(url).document
        return doc.select("div.anime-item, div.flim-item, article.item, .post, .list-item").mapNotNull { it.toSearchResult() }
    }

    override suspend fun load(url: String): LoadResponse {
        val doc = app.get(url).document
        val title = doc.selectFirst("h1, .anime-title, .title, .entry-title")?.text()?.trim() ?: "Unknown"
        val poster = doc.selectFirst("img.poster, .poster img, .thumbnail img, img")?.let { it.attr("data-src").ifEmpty { it.attr("src") } }
        val description = doc.selectFirst(".description, .summary, .synopsis, .entry-content, p")?.text()?.trim()
        val tags = doc.select(".genres a, .tag a").map { it.text().trim() }
        val episodes = doc.select(".episode-list a, .episodes a, .season-list li a").map { episodeElement ->
            newEpisode(episodeElement.attr("href")) { name = episodeElement.text().trim() }
        }

        return newAnimeLoadResponse(title, url, TvType.Anime) {
            posterUrl = poster
            plot = description
            this.tags = tags
            addEpisodes(DubStatus.None, episodes)
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
