package com.cs3repo.individual.yenime

import com.cs3repo.anime.YenimeProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class YenimePlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(YenimeProvider())
    }
}
