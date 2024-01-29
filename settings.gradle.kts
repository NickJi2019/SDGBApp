rootProject.name = "SDGBApp"



pluginManagement {
    repositories {
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        if (settings.providers.gradleProperty("inMainlandChina").get()=="false"){
            google()
            gradlePluginPortal()
            mavenCentral()
        }else{
            println("using aliyun maven repo")
            maven("https://maven.aliyun.com/repository/public/")
            maven("https://maven.aliyun.com/repository/google/")
            maven("https://maven.aliyun.com/repository/gradle-plugin/")
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")

        if (settings.providers.gradleProperty("inMainlandChina").get()=="false"){
            google()
            mavenCentral()
        }else{
            println("using aliyun maven repo")
            maven("https://maven.aliyun.com/repository/public/")
            maven("https://maven.aliyun.com/repository/google/")
        }
    }
}

include(":server")
include(":shared")
include(":composeApp")