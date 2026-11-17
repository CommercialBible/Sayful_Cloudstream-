package com.cs3repo.individual.arrowtv

import com.cs3repo.moviesshows.ArrowTVProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class ArrowTVPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(ArrowTVProvider())
    }
}
