package com.cs3repo.individual.weebcentral

import com.cs3repo.manga.WeebCentralProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class WeebCentralPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(WeebCentralProvider())
    }
}
