package com.cs3repo.individual.qtoon

import com.cs3repo.manga.QToonProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class QToonPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(QToonProvider())
    }
}
