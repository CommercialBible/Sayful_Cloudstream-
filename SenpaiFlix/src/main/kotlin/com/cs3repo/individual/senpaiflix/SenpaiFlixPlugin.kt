package com.cs3repo.individual.senpaiflix

import com.cs3repo.anime.SenpaiFlixProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class SenpaiFlixPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(SenpaiFlixProvider())
    }
}
