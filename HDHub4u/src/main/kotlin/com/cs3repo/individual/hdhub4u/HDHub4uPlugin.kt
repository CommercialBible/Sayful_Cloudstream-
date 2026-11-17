package com.cs3repo.individual.hdhub4u

import com.cs3repo.moviesshows.HDHub4uProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class HDHub4uPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(HDHub4uProvider())
    }
}
