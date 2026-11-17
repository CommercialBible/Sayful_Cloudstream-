package com.cs3repo.individual.webtoons

import com.cs3repo.manga.WebtoonsProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class WebtoonsPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(WebtoonsProvider())
    }
}
