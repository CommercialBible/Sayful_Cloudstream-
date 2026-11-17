package com.cs3repo.individual.willow

import com.cs3repo.moviesshows.WillowProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class WillowPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(WillowProvider())
    }
}
