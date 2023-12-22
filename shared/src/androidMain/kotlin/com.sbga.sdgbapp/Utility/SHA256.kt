package com.sbga.sdgbapp.Utility

import java.security.MessageDigest

actual object SHA256 {
    @OptIn(ExperimentalStdlibApi::class)
    actual fun sha256(input: String): String {
        return MessageDigest.getInstance("SHA256").digest(input.encodeToByteArray()).toHexString()
    }
}