package com.cs3repo.anime

import com.lagradost.cloudstream3.plugins.BasePlugin

class AnimePlugin : BasePlugin() {
    override fun load() {
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
