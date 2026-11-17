version = 1
cloudstream {
    language = "en"
    description = "Webtoons provider"
    authors = listOf("CommercialBible")
    status = 1
    tvTypes = listOf("TvSeries")
}

android {
    sourceSets.getByName("main").java.srcDir("../MangaPlugin/src/main/kotlin")
    sourceSets.getByName("main").java.exclude("**/MangaPlugin.kt")
}
