package com.sbga.sdgbapp.Utility
object Extensions {
    fun ByteArray.deflate(): ByteArray = Compressor.deflate(this)
    fun ByteArray.inflate(): ByteArray = Compressor.inflate(this)
    fun String.md5(): ByteArray = MD5.md5(this)
    @OptIn(ExperimentalStdlibApi::class)
    fun Any.md5String(): String = this.toString().md5().toHexString()
    fun ByteArray.encrypt(): ByteArray = CipherAES.encrypt(this)
    fun ByteArray.decrypt(): ByteArray = CipherAES.decrypt(this)
    inline fun <reified T> String.deserialize(): T = JsonUtil.deserialize(this)
    inline fun <reified T> ByteArray.deserialize(): T = JsonUtil.deserialize(this.decodeToString())
    inline fun <reified T> T.serialize(): String = JsonUtil.serialize(this)
    fun String.sha256(): String = SHA256.sha256(this)
    inline fun <reified T> T.logI(): T = this.also { log.info(it) }
    fun Array<*>.alsoLogArrI():Array<*> = this.also { log.info(*this) }
    fun ByteArray.alsoLogArrI():ByteArray = this.also { log.info(*this.toTypedArray()) }
}