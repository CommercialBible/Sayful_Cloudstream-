package com.cs3repo.individual.cinehd

import com.cs3repo.moviesshows.CineHDProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class CineHDPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(CineHDProvider())
    }
}
