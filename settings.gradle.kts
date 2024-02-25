pluginManagement {
    repositories {
//        maven("https://maven.aliyun.com/repository/public/")
//        maven("https://maven.aliyun.com/repositories/jcenter")
//        maven("https://maven.aliyun.com/repositories/google")
//        maven("https://maven.aliyun.com/repositories/central")
        mavenCentral()
        gradlePluginPortal()
    }
}

//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        maven("https://maven.aliyun.com/repository/public/")
//        maven("https://maven.aliyun.com/repositories/jcenter")
//        maven("https://maven.aliyun.com/repositories/google")
//        maven("https://maven.aliyun.com/repositories/central")
//        mavenCentral()
//    }
//}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "KanaAssistant"