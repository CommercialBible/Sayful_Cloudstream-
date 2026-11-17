package com.cs3repo.individual.justanime

import com.cs3repo.anime.JustAnimeProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class JustAnimePlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(JustAnimeProvider())
    }
}
