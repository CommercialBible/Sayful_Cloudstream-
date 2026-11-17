package com.cs3repo.individual.anikototv

import com.cs3repo.anime.AnikotoTVProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class AnikotoTVPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AnikotoTVProvider())
    }
}
