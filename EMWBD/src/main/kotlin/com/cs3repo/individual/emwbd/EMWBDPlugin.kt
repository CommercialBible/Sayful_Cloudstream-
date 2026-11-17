package com.cs3repo.individual.emwbd

import com.cs3repo.moviesshows.EMWBDProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class EMWBDPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(EMWBDProvider())
    }
}
