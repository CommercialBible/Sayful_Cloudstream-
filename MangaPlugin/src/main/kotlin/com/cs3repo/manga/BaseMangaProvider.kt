package com.cs3repo.manga

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.ExtractorLink
import com.lagradost.cloudstream3.utils.newExtractorLink
import org.jsoup.nodes.Element

abstract class BaseMangaProvider : MainAPI() {
    override var mainUrl: String = ""
    override var name: String = "Manga"
    override val supportedTypes = setOf(TvType.TvSeries)
    override val hasMainPage = true
    override val mainPage = mainPageOf(MainPageData("Latest Manga", mainUrl))

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse? {
        val doc = app.get(request.data).document
        val results = doc.select("div.manga-item, div.list-item, article.item, .entry, .post, .bs, .item").mapNotNull { it.toSearchResult() }
        return newHomePageResponse(request, results, false)
    }
    protected open val searchUrl: String = "/?s="

    protected open fun Element.toSearchResult(): SearchResponse? {
        val title = selectFirst("h3, h2, .title, .name, a.title")?.text()?.trim() ?: return null
        val href = fixUrl(selectFirst("a")?.attr("href") ?: return null)
        val poster = selectFirst("img")?.let { it.attr("data-src").ifEmpty { it.attr("src") } }
        return newTvSeriesSearchResponse(title, href, TvType.TvSeries) { addPoster(poster) }
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val url = if (mainUrl.endsWith("/")) "${mainUrl}${searchUrl.trimStart('/')}$query" else "$mainUrl$searchUrl$query"
        val doc = app.get(url).document
        return doc.select("div.manga-item, div.list-item, article.item, .entry, .post").mapNotNull { it.toSearchResult() }
    }

    override suspend fun load(url: String): LoadResponse {
        val doc = app.get(url).document
        val title = doc.selectFirst("h1, .manga-title, .title, .entry-title")?.text()?.trim() ?: "Unknown"
        val poster = doc.selectFirst("img.poster, .poster img, .thumbnail img, img")?.let { it.attr("data-src").ifEmpty { it.attr("src") } }
        val description = doc.selectFirst(".description, .summary, .synopsis, .entry-content, p")?.text()?.trim()
        val tags = doc.select(".genres a, .tag a").map { it.text().trim() }
        val chapters = doc.select(".chapter-list a, .chapters a, .list-chapter a").map { chapterElement ->
            newEpisode(fixUrl(chapterElement.attr("href"))) { name = chapterElement.text().trim() }
        }

        return newTvSeriesLoadResponse(title, url, TvType.TvSeries, chapters) {
            posterUrl = poster
            plot = description
            this.tags = tags
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        val doc = app.get(data).document
        doc.select("img.page-img, .reading-content img, .manga-page img, img.chapter-img").forEach { element ->
            val link = element.attr("data-src").ifEmpty { element.attr("src") }
            if (link.isNotEmpty()) {
                callback(newExtractorLink(name, name, fixUrl(link)))
            }
        }
        return true
    }
}
