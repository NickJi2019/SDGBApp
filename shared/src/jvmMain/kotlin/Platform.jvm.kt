class JvmPlatform : Platform {
    override val name: String = "Jvm ${System.getProperties().let { "${it["java.version"]} ${it["java.vendor"]}" }}"
}

actual fun getPlatform(): Platform = JvmPlatform()