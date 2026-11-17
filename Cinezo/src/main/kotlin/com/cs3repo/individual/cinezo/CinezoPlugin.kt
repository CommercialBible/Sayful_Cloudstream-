package com.cs3repo.individual.cinezo

import com.cs3repo.moviesshows.CinezoProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class CinezoPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(CinezoProvider())
    }
}
