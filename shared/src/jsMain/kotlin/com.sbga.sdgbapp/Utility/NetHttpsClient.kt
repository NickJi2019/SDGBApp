package com.sbga.sdgbapp.Utility

actual class NetHttpsClient : NetHttpClient {
    actual constructor(url: String) : super(url) {
        TODO("Not yet implemented")
    }

    actual override fun request(
        header: Map<String, String>?,
        body: ByteArray,
        method: String
    ): NetHttpClient {
        TODO("Not yet implemented")
    }
}