plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    jvm()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods{
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
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


    sourceSets {
        commonMain.dependencies {
            implementation(libs.napier)
//            implementation(libs.ktor.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
            implementation("org.jetbrains.kotlinx:kotlinx-io-core:0.3.0")
        }
        jvmMain.dependencies {
//            implementation(libs.ktor.client.okhttp)
        }
        androidMain.dependencies {
//            implementation(libs.ktor.client.okhttp)

        }
        appleMain.dependencies {
//            implementation(libs.ktor.client.darwin)
        }
        jsMain.dependencies {
            implementation(npm("crypto-js", "3.1.9-1"))
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
        jsTest.dependencies {
            implementation(kotlin("test-js"))
        }
        jvmTest.dependencies {
            implementation(kotlin("test-junit"))
        }

    }
}

android {
    namespace = "com.sbga.sdgbapp.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}
dependencies {
    implementation("io.ktor:ktor-client-okhttp-jvm:2.3.6")
    androidTestImplementation("junit:junit:4.13.2")
}
