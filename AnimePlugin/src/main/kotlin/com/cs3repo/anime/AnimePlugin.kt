package com.cs3repo.anime

import android.content.Context
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin
import com.lagradost.cloudstream3.plugins.Plugin

@CloudstreamPlugin
class AnimePlugin : Plugin() {
    override fun load(context: Context) {
        registerMainAPI(AniShowsProvider())
        registerMainAPI(AniWavesProvider())
        registerMainAPI(AnikotoTVProvider())
        registerMainAPI(AnimeRulzProvider())
        registerMainAPI(AnimeSaltProvider())
        registerMainAPI(AnimeTVPlusProvider())
        registerMainAPI(AnimetsuProvider())
        registerMainAPI(DubAnimePlayProvider())
        registerMainAPI(EnmaProvider())
        registerMainAPI(FlixAniProvider())
        registerMainAPI(HiAnimeProvider())
        registerMainAPI(JustAnimeProvider())
        registerMainAPI(KaaProvider())
        registerMainAPI(OtanoxProvider())
        registerMainAPI(SenpaiFlixProvider())
        registerMainAPI(WatchAnimezProvider())
        registerMainAPI(YenimeProvider())
    }
}
