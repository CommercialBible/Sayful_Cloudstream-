package com.cs3repo.individual.otanox

import com.cs3repo.anime.OtanoxProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class OtanoxPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(OtanoxProvider())
    }
}
