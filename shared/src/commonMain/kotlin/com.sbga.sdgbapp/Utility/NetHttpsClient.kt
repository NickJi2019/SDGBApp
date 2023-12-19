package com.sbga.sdgbapp.Utility

expect class NetHttpsClient: NetHttpClient {
    constructor(url:String)
    override fun request(headers: Map<String, String>, body: ByteArray, method:String): NetHttpClient
}