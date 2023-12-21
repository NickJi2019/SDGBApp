package com.sbga.sdgbapp.Utility

actual open class NetHttpClient : INetHttpClient {
    actual constructor(url: String) {
        TODO("Not yet implemented")
    }

    actual override fun request(
        header: Map<String, String>,
        body: ByteArray,
        method: String
    ): NetHttpClient {
        TODO("Not yet implemented")
    }

    actual override fun getResponse(): ByteArray {
        TODO("Not yet implemented")
    }

    actual override fun finalize() {
    }
}