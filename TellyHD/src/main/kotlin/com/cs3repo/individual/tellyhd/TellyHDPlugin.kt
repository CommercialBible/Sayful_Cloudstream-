package com.cs3repo.individual.tellyhd

import com.cs3repo.moviesshows.TellyHDProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class TellyHDPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(TellyHDProvider())
    }
}
