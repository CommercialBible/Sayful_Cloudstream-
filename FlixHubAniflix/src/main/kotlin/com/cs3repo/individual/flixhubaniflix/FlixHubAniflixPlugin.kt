package com.cs3repo.individual.flixhubaniflix

import com.cs3repo.moviesshows.FlixHubAniflixProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class FlixHubAniflixPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(FlixHubAniflixProvider())
    }
}
