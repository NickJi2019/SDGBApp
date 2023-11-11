plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
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
            // put your Multiplatform dependencies here
        }
        jsTest.dependencies {
            //TODO
            implementation(kotlin("test-js"))
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
