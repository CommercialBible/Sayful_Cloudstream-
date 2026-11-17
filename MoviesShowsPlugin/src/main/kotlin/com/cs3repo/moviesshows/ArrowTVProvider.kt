package com.cs3repo.moviesshows

import com.lagradost.cloudstream3.TvType
class ArrowTVProvider : BaseMoviesShowsProvider() {
    override var mainUrl = "https://arrowtv.net"
    override var name = "ArrowTV"
    override val supportedTypes = setOf(TvType.TvSeries)
}
