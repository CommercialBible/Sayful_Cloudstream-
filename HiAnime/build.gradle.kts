version = 1
cloudstream {
    language = "en"
    description = "HiAnime provider"
    authors = listOf("CommercialBible")
    status = 1
    tvTypes = listOf("Anime", "AnimeSeries")
}

android {
    sourceSets.getByName("main").java.srcDir("../AnimePlugin/src/main/kotlin")
    sourceSets.getByName("main").java.exclude("**/AnimePlugin.kt")
}
