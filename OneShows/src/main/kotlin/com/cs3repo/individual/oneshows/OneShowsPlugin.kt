package com.cs3repo.individual.oneshows

import com.cs3repo.moviesshows.OneShowsProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class OneShowsPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(OneShowsProvider())
    }
}
