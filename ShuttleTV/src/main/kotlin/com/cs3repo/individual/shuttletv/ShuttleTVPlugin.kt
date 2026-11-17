package com.cs3repo.individual.shuttletv

import com.cs3repo.moviesshows.ShuttleTVProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class ShuttleTVPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(ShuttleTVProvider())
    }
}
