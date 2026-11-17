package com.cs3repo.individual.comick

import com.cs3repo.manga.ComicKProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class ComicKPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(ComicKProvider())
    }
}
