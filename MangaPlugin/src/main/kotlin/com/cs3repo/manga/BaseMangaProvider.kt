        val title = this.selectFirst("h3, h2, .title, .name, a.title")?.text()?.trim() ?: return null
        val href = fixUrl(this.selectFirst("a")?.attr("href") ?: return null)
        val poster = this.selectFirst("img")?.let { it.attr("data-src").ifEmpty { it.attr("src") } }
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
            newEpisode(chapterElement.attr("href")) { name = chapterElement.text().trim() }
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
                val absLink = fixUrl(link)
                callback(newExtractorLink(this@BaseMangaProvider.name, this@BaseMangaProvider.name, absLink))
            }
        }
        return true
    }
}
