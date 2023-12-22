package com.sbga.sdgbapp.Utility

import kotlinx.cinterop.*
import platform.CoreCrypto.CC_SHA256
import platform.CoreCrypto.CC_SHA256_DIGEST_LENGTH

actual object SHA256 {
    @OptIn(ExperimentalForeignApi::class, ExperimentalStdlibApi::class)
    actual fun sha256(input: String): String {
        memScoped {
            val digest = allocArray<ByteVar>(CC_SHA256_DIGEST_LENGTH)
            CC_SHA256(input.encodeToByteArray().toCValues(), input.length.convert(), digest as CValuesRef<UByteVar>)
            return digest.readBytes(CC_SHA256_DIGEST_LENGTH).toHexString()
        }
    }
}