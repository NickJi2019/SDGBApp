package com.sbga.sdgbapp.Utility


interface INetHttpClient {
    var headers:Map<String, String>
    fun request(header: Map<String, String>? = this.headers, body:ByteArray, method:String): NetHttpClient
    fun getResponse(): ByteArray
    fun finalize()
}


