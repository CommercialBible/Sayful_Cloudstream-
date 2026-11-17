package com.cs3repo.individual.animetsu

import com.cs3repo.anime.AnimetsuProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class AnimetsuPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AnimetsuProvider())
    }
}
