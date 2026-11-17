package com.cs3repo.individual.sevenreels

import com.cs3repo.moviesshows.SevenReelsProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class SevenReelsPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(SevenReelsProvider())
    }
}
