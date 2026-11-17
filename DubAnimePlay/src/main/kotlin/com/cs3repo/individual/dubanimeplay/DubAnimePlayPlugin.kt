package com.cs3repo.individual.dubanimeplay

import com.cs3repo.anime.DubAnimePlayProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class DubAnimePlayPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(DubAnimePlayProvider())
    }
}
