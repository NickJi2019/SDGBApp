package com.sbga.sdgbapp.Utility

expect open class NetHttpClient: INetHttpClient {
    constructor(url:String)
    override fun request(headers: Map<String, String>, body: ByteArray, method:String): NetHttpClient
    override fun getResponse(): ByteArray
    override fun finalize()
}