package com.sbga.sdgbapp.Utility

expect object CipherAES {
    fun encrypt(data: ByteArray): ByteArray
    fun decrypt(data: ByteArray): ByteArray

}

