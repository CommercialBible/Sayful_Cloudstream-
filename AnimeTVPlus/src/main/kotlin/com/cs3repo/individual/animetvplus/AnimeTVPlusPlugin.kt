package com.cs3repo.individual.animetvplus

import com.cs3repo.anime.AnimeTVPlusProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class AnimeTVPlusPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AnimeTVPlusProvider())
    }
}
