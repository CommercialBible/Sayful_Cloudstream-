package com.cs3repo.individual.hianime

import com.cs3repo.anime.HiAnimeProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class HiAnimePlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(HiAnimeProvider())
    }
}
