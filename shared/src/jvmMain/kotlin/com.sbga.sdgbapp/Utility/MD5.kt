package com.sbga.sdgbapp.Utility

import java.security.MessageDigest

actual object MD5 {

    val module = MessageDigest.getInstance("MD5")
    actual fun md5(string: String): ByteArray {
        return module.digest(string.encodeToByteArray())
    }

}