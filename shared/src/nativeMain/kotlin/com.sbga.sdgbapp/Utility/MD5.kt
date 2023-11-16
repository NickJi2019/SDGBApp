package com.sbga.sdgbapp.Utility

import kotlinx.cinterop.*
import platform.CoreCrypto.CC_MD5
import platform.posix.calloc
import platform.posix.free


actual object MD5 {
    @OptIn(ExperimentalForeignApi::class)
    actual fun md5(string: String): ByteArray {
        memScoped {
            val str = string.pin()
            val result = calloc(8u, 16u) as CValuesRef<UByteVar>
            CC_MD5(
                str.get().encodeToByteArray().toCValues(),
                str.get().encodeToByteArray().size.convert(),
                result
            )
            val re = (result as CPointer).readBytes(16)

            free(result)
            str.unpin()
            return re
        }
    }
}