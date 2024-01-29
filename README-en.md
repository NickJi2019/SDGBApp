# SDGBApp

## A unified custom maimai forwarding server

[Chinese](./README.md)

### Development Guide

For developers in mainland China, please first edit [gradle.properties](./gradle.properties) and change the value of
`inMainlandChina` to `true`to enable Alibaba Cloud images to accurate builds.


If an error occurs in `:shared:podSetupBuildAFNetworkingIphonesimulator` when doing a gradle build, please try to delete `/shared/build/` and build again.

This is a Kotlin multi-platform project targeting Android, iOS, desktop, server and browser.

* `/shared` is used for code that will be shared between all targets in the project.
  The most important subfolder is "commonMain".
  If you like, you can add the code to
  Platform specific folders are also here.

* `/server` is for Ktor server applications.
x
* `/composeApp` is mainly used to store UI code, code used for sharing between your Compose multi-platform applications.
  It contains several subfolders:
    - `commonMain` for code common to all targets.
    - Other folders are for Kotlin code that will only be compiled for the platform specified in the folder name.
      For example, if you want to use Apple's CoreCrypto for the iOS portion of your Kotlin application,
      `iosMain` would be the correct folder for such calls.

* `/iosApp` contains iOS applications. Even if you share the UI with Compose Multiplatform,
  Your iOS application requires this entry point. This is also where you should add SwiftUI code to your project.

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)...