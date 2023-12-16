package com.sbga.sdgbapp.Utility

//external fun decryptText(encryptedText: String, key: dynamic, iv: dynamic): String
//external fun encryptText(text: String, key: dynamic, iv: dynamic): String

actual object CipherAES {
    //TODO
    //not functional
    private val CryptoJS: dynamic
    private val key: dynamic
    private val iv: dynamic

    init {
        println("aes init")
        CryptoJS = js("require('crypto-js')")
        println("aes init")
        println(CryptoJS)
        key = CryptoJS.enc.Utf8.parse(AesKey)
        iv = CryptoJS.enc.Utf8.parse(AesIV)
    }




    actual fun encrypt(data: String): String {
        TODO("Not yet implemented")
    }

    actual fun encrypt(data: ByteArray): ByteArray {
        TODO("Not yet implemented")
    }

    actual fun decrypt(data: String): String {
        TODO("Not yet implemented")
    }

    actual fun decrypt(data: ByteArray): ByteArray {
        TODO("Not yet implemented")
    }
}