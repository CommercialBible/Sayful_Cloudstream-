package com.cs3repo.manga

import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class MangaPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(AniReadsProvider())
        registerMainAPI(ComicKProvider())
        registerMainAPI(KingOfShojoProvider())
        registerMainAPI(MangaBallProvider())
        registerMainAPI(QToonProvider())
        registerMainAPI(WebtoonsProvider())
        registerMainAPI(WeebCentralProvider())
    }
}
