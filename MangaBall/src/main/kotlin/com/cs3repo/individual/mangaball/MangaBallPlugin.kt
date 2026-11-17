package com.cs3repo.individual.mangaball

import com.cs3repo.manga.MangaBallProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class MangaBallPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(MangaBallProvider())
    }
}
