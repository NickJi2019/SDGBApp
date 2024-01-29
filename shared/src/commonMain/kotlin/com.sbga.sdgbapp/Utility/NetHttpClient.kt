package com.sbga.sdgbapp.Utility

expect open class NetHttpClient: INetHttpClient {
    constructor(url:String)
    override fun requestAsync(
        header: Map<String, String>?,
        body: ByteArray,
        method: String,
        completion: (ByteArray?) -> Unit
    ): Unit
    override fun requestSync(header: Map<String, String>?, body: ByteArray, method:String): ByteArray?
    override fun finalize()
}