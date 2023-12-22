package com.sbga.sdgbapp.Utility

actual class NetHttpsClient : NetHttpClient {
    actual constructor(url: String) : super(url)
    actual override fun request(header: Map<String, String>?, body: ByteArray, method: String): NetHttpClient {
        return super.request(header, body, method)
    }
    actual override fun getResponse(): ByteArray {
        return super.getResponse()
    }
    actual override fun finalize() {
        super.finalize()
    }
}