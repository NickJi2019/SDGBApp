rootProject.name = "SDGBApp"

pluginManagement {
    repositories {
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")

        //----------for developer in China mainland, please comment out the following line----------
        google()
        gradlePluginPortal()
        mavenCentral()
        //----------and uncomment the following line to enable aliyun repositories----------
//        maven("https://maven.aliyun.com/repository/public/")
//        maven("https://maven.aliyun.com/repository/google/")
//        maven("https://maven.aliyun.com/repository/gradle-plugin/")

    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        //----------for developer in China mainland, please comment out the following line----------
        google()
        mavenCentral()
        //----------and uncomment the following line to enable aliyun repositories----------
//        maven("https://maven.aliyun.com/repository/public/")
//        maven("https://maven.aliyun.com/repository/google/")
    }
}

include(":server")
include(":shared")
include(":composeApp")