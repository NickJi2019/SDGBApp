package com.sbga.sdgbapp.Utility

interface INetHttpClient {
    fun requestAsync(header: Map<String, String>?, body:ByteArray, method:String, completion: (ByteArray?) -> Unit): Unit
    fun requestSync(header: Map<String, String>?, body:ByteArray, method:String): ByteArray?
    fun finalize()
}


