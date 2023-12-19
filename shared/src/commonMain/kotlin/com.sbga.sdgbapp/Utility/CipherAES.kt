package com.sbga.sdgbapp.Utility

expect object CipherAES {
    fun encrypt(data:String): String
    fun decrypt(data: String): String
    fun encrypt(data: ByteArray): ByteArray
    fun decrypt(data: ByteArray): ByteArray

}

