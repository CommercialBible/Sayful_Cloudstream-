package com.cs3repo.individual.pantyflix

import com.cs3repo.moviesshows.PantyFlixProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class PantyFlixPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(PantyFlixProvider())
    }
}
