package com.cs3repo.individual.gaiaflix

import com.cs3repo.moviesshows.GaiaFlixProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class GaiaFlixPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(GaiaFlixProvider())
    }
}
