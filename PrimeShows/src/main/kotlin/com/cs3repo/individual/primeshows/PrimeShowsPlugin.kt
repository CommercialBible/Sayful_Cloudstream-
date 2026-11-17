package com.cs3repo.individual.primeshows

import com.cs3repo.moviesshows.PrimeShowsProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class PrimeShowsPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(PrimeShowsProvider())
    }
}
