package com.cs3repo.individual.thugtv

import com.cs3repo.moviesshows.ThugTVProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class ThugTVPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(ThugTVProvider())
    }
}
