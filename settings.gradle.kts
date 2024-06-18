enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")


pluginManagement {
    val mavenJetBrains: String by settings
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven {
            this.url = uri(
                path =  mavenJetBrains
            )
        }
    }
}

dependencyResolutionManagement {
    val mavenJetBrains: String by settings
    repositories {
        google()
        mavenCentral()
        maven {
            this.url = uri(
                path =  mavenJetBrains
            )
        }
    }
}

rootProject.name = "DailyPulse"
include(":androidApp")
include(":shared")