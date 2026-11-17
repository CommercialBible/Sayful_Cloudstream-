package com.cs3repo.individual.vuflix

import com.cs3repo.moviesshows.VuFlixProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class VuFlixPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(VuFlixProvider())
    }
}
