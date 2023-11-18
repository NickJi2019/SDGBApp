plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20"
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    js {
        browser {
            testTask {
                useKarma {
                    useSafari()
                }
            }
        }
        binaries.executable()
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.junit)
            implementation("io.github.aakira:napier:2.6.1")
            implementation("io.ktor:ktor-client-core:2.3.5")
            implementation("io.ktor:ktor-client-encoding:2.3.5")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
//            implementation("io.ktor:ktor-client-cio:$2.3.5")
//            implementation(project(":compression"))
//            implementation(project(":e2e"))
            // put your Multiplatform dependencies here
        }
        jsTest.dependencies {
            //TODO
            implementation(kotlin("test-js"))
        }
        appleMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:2.3.5")
        }
        jvmMain.dependencies {
            implementation("io.ktor:ktor-client-okhttp:2.3.5")
        }
        androidMain.dependencies {
            implementation("io.ktor:ktor-client-okhttp:2.3.5")
        }
    }
}

android {
    namespace = "com.sbga.sdgbapp.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
