version = 1
cloudstream {
    language = "en"
    description = "FlixHubAniflix provider"
    authors = listOf("CommercialBible")
    status = 1
    tvTypes = listOf("Movie", "TvSeries")
}

android {
    sourceSets.getByName("main").java.srcDir("../MoviesShowsPlugin/src/main/kotlin")
    sourceSets.getByName("main").java.exclude("**/MoviesShowsPlugin.kt")
}
