package com.cs3repo.individual.redflix

import com.cs3repo.moviesshows.RedFlixProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class RedFlixPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(RedFlixProvider())
    }
}
