# Sayful CloudStream Repository

CloudStream extension source repository for Movies & Shows, Anime, and Manga.

Push source changes to `main`. GitHub Actions builds all three plugins using the recloudstream Gradle plugin and publishes `.cs3` files, `plugins.json`, and `repo.json` to the `builds` branch.

Add this repository to CloudStream after a successful build:

`https://raw.githubusercontent.com/CommercialBible/Sayful_Cloudstream-/builds/repo.json`

The `builds` branch is generated automatically; do not edit it manually. Individual provider websites and selectors still require runtime testing in CloudStream.
