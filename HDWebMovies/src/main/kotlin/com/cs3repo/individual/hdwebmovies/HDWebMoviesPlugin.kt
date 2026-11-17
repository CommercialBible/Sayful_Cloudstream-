package com.cs3repo.individual.hdwebmovies

import com.cs3repo.moviesshows.HDWebMoviesProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class HDWebMoviesPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(HDWebMoviesProvider())
    }
}
