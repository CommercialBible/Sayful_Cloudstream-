package com.cs3repo.manga

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class MangaPlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(AniReadsProvider())
        registerMainAPI(ComicKProvider())
        registerMainAPI(KingOfShojoProvider())
        registerMainAPI(MangaBallProvider())
        registerMainAPI(QToonProvider())
        registerMainAPI(WebtoonsProvider())
        registerMainAPI(WeebCentralProvider())
    }
}
