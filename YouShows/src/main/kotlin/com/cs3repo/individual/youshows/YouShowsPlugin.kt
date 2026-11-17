package com.cs3repo.individual.youshows

import com.cs3repo.moviesshows.YouShowsProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class YouShowsPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(YouShowsProvider())
    }
}
