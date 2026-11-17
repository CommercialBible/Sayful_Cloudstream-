package com.cs3repo.individual.onetube

import com.cs3repo.moviesshows.OneTubeProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class OneTubePlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(OneTubeProvider())
    }
}
