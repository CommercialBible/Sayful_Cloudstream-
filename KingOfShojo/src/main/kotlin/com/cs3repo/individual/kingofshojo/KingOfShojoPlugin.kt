package com.cs3repo.individual.kingofshojo

import com.cs3repo.manga.KingOfShojoProvider
import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class KingOfShojoPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(KingOfShojoProvider())
    }
}
