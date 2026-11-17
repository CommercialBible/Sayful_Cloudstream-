package com.cs3repo.moviesshows

import com.lagradost.cloudstream3.plugins.BasePlugin

class MoviesShowsPlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(ArrowTVProvider())
        registerMainAPI(CineHDProvider())
        registerMainAPI(CineXProvider())
        registerMainAPI(CinezoProvider())
        registerMainAPI(EMWBDProvider())
        registerMainAPI(FlixHubAniflixProvider())
        registerMainAPI(GaiaFlixProvider())
        registerMainAPI(GhostFlixProvider())
        registerMainAPI(HDHub4uProvider())
        registerMainAPI(HDWebMoviesProvider())
        registerMainAPI(MovieLinkBDProvider())
        registerMainAPI(OneFlexProvider())
        registerMainAPI(OneShowsProvider())
        registerMainAPI(OneTubeProvider())
        registerMainAPI(PantyFlixProvider())
        registerMainAPI(PrimeShowsProvider())
        registerMainAPI(RedFlixProvider())
        registerMainAPI(SevenReelsProvider())
        registerMainAPI(ShuttleTVProvider())
        registerMainAPI(TellyHDProvider())
        registerMainAPI(ThugTVProvider())
        registerMainAPI(VuFlixProvider())
        registerMainAPI(WillowProvider())
        registerMainAPI(YouShowsProvider())
    }
}
