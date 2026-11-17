package com.cs3repo.individual.enma

import com.cs3repo.anime.EnmaProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class EnmaPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(EnmaProvider())
    }
}
