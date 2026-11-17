package com.cs3repo.individual.anireads

import com.cs3repo.manga.AniReadsProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class AniReadsPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AniReadsProvider())
    }
}
