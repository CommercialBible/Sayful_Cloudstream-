package com.cs3repo.individual.aniwaves

import com.cs3repo.anime.AniWavesProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class AniWavesPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AniWavesProvider())
    }
}
