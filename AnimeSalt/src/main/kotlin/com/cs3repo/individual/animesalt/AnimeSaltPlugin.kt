package com.cs3repo.individual.animesalt

import com.cs3repo.anime.AnimeSaltProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class AnimeSaltPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AnimeSaltProvider())
    }
}
