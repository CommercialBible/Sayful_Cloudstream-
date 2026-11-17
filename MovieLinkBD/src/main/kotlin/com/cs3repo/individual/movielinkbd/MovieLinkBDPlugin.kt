package com.cs3repo.individual.movielinkbd

import com.cs3repo.moviesshows.MovieLinkBDProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class MovieLinkBDPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(MovieLinkBDProvider())
    }
}
