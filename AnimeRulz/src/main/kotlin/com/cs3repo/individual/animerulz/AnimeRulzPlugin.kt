package com.cs3repo.individual.animerulz

import com.cs3repo.anime.AnimeRulzProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class AnimeRulzPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AnimeRulzProvider())
    }
}
