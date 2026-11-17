package com.cs3repo.individual.kaa

import com.cs3repo.anime.KaaProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class KaaPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(KaaProvider())
    }
}
