package com.sbga.sdgbapp.Utility
object Extensions {
    fun ByteArray.deflate(): ByteArray = Compressor.deflate(this)
    fun ByteArray.inflate(): ByteArray = Compressor.inflate(this)
    fun String.deflate(): String = Compressor.deflate(this.encodeToByteArray()).decodeToString()
    fun String.inflate(): String = Compressor.inflate(this.encodeToByteArray()).decodeToString()
    fun String.md5(): ByteArray = MD5.md5(this)
    @OptIn(ExperimentalStdlibApi::class)
    fun Any.md5String(): String = MD5.md5(this.toString()).toHexString()
    fun String.encrypt(): String = CipherAES.encrypt(this)
    fun String.decrypt(): String = CipherAES.decrypt(this)
    fun ByteArray.encrypt(): ByteArray = CipherAES.encrypt(this)
    fun ByteArray.decrypt(): ByteArray = CipherAES.decrypt(this)
    inline fun <reified T> String.deserialize(): T = JsonUtil.deserialize(this)
    inline fun <reified T> ByteArray.deserialize(): T = JsonUtil.deserialize(this.decodeToString())
    inline fun <reified T> T.serialize(): String = JsonUtil.serialize(this)
    fun String.sha256(): String = SHA256.sha256(this)
}