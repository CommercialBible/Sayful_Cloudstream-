package com.cs3repo.individual.cinex

import com.cs3repo.moviesshows.CineXProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class CineXPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(CineXProvider())
    }
}
