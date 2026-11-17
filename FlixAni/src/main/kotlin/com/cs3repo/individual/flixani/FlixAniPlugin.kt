package com.cs3repo.individual.flixani

import com.cs3repo.anime.FlixAniProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class FlixAniPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(FlixAniProvider())
    }
}
