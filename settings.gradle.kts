pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Compose Navigation"
include(":app")
include(":core:ui")
include(":core:designsystem")
include(":core:common")
include(":core:model")
include(":core:database")
include(":core:network")
include(":core:datastore")
include(":domain")
