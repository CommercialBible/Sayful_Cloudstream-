package com.cs3repo.moviesshows

import com.lagradost.cloudstream3.TvType
class ShuttleTVProvider : BaseMoviesShowsProvider() {
    override var mainUrl = "https://shuttletv.su"
    override var name = "ShuttleTV"
    override val supportedTypes = setOf(TvType.TvSeries)
}
