package com.sbga.sdgbapp.Utility


interface INetHttpClient {
    fun request(headers: Map<String,String>, body:ByteArray, method:String): NetHttpClient
    fun getResponse(): ByteArray
    fun finalize()
}


