package com.sbga.sdgbapp.Utility
object Extensions {
    fun ByteArray.deflate(): ByteArray = Compressor.deflate(this)
    fun ByteArray.inflate(): ByteArray = Compressor.inflate(this)
    fun String.md5(): ByteArray = MD5.md5(this)
    fun String.encrypt(): String = CipherAES.encrypt(this)
    fun String.decrypt(): String = CipherAES.decrypt(this)
    fun ByteArray.encrypt(): ByteArray = CipherAES.encrypt(this)
    fun ByteArray.decrypt(): ByteArray = CipherAES.decrypt(this)
}