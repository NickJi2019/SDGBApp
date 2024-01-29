# SDGBApp 
## 一个统合的自定义maimai转发服务器
[English](./README-en.md)

### 开发指南
对于在中国大陆的开发者，请首先编辑[gradle.properties](./gradle.properties)文件，将
`inMainlandChina`的值改为`true`以启用阿里云镜像并加快构建速度。

如果在进行gradle构建时`:shared:podSetupBuildAFNetworkingIphonesimulator`出现错误，请尝试删除`/shared/build/`和`/iosApp/Pods`并重新构建。

这是一个针对 安卓、iOS、桌面、服务器和浏览器的 Kotlin 多平台项目。

* `/shared` 用于将在项目中的所有目标之间共享的代码。
  最重要的子文件夹是“commonMain”。
  如果愿意，您可以将代码添加到
  平台特定的文件夹也在这里。

* `/server` 用于 Ktor 服务器应用程序。

* `/composeApp` 主要用于存放UI代码，用于在您的 Compose 多平台应用程序之间共享的代码。
  它包含几个子文件夹：
  - `commonMain` 用于所有目标通用的代码。
  - 其他文件夹用于存放 Kotlin 代码，这些代码将仅针对文件夹名称中指定的平台进行编译。
    例如，如果您想将 Apple 的 CoreCrypto 用于 Kotlin 应用程序的 iOS 部分，
    `iosMain` 将是此类调用的正确文件夹。

* `/iosApp` 包含 iOS 应用程序。 即使您与 Compose Multiplatform 共享 UI，
  您的 iOS 应用程序需要此入口点。 这也是您应该为项目添加 SwiftUI 代码的地方。

了解有关 [Kotlin 多平台](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html) 的更多信息...