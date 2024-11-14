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

rootProject.name = "Cofflyz"
include(":app")
buildscript {
    repositories {
        google()  // Repositori Google untuk Firebase
        mavenCentral()
    }
    dependencies {
        classpath ("com.google.gms:google-services:4.4.2") // Plugin Google Services
    }
}
