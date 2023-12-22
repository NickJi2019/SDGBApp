package com.sbga.sdgbapp.Utility

expect open class NetHttpClient: INetHttpClient {
    override var headers: Map<String, String>
    constructor(url:String)
    override fun request(header: Map<String, String>?, body: ByteArray, method:String): NetHttpClient
    override fun getResponse(): ByteArray
    override fun finalize()
}