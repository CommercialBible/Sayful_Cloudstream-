package com.cs3repo.individual.ghostflix

import com.cs3repo.moviesshows.GhostFlixProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class GhostFlixPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(GhostFlixProvider())
    }
}
