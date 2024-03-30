pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "CalorieTracker"
include(":app")
include(":core")
include(":onboarding")
include(":onboarding:presentation")
include(":onboarding:domain")
include(":tracker")
include(":tracker:data")
include(":tracker:domain")
include(":tracker:presentation")
include(":core-ui")
