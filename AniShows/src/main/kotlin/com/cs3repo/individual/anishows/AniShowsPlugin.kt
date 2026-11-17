package com.cs3repo.individual.anishows

import com.cs3repo.anime.AniShowsProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class AniShowsPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AniShowsProvider())
    }
}
