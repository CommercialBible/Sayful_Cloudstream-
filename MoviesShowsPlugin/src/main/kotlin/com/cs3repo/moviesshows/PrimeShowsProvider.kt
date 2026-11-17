package com.cs3repo.moviesshows

import com.lagradost.cloudstream3.TvType
class PrimeShowsProvider : BaseMoviesShowsProvider() {
    override var mainUrl = "https://primeshows.org"
    override var name = "PrimeShows"
    override val supportedTypes = setOf(TvType.TvSeries)
}
