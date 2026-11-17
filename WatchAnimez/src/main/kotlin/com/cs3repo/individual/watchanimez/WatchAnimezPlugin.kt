package com.cs3repo.individual.watchanimez

import com.cs3repo.anime.WatchAnimezProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class WatchAnimezPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(WatchAnimezProvider())
    }
}
