package com.sbga.sdgbapp.Utility

import java.net.HttpURLConnection
import java.net.URL

actual open class NetHttpClient : INetHttpClient {

    private var urlConnection:HttpURLConnection
    actual constructor(url: String) {
        urlConnection = URL(url).openConnection() as HttpURLConnection
    }

    actual override fun request(
        headers: Map<String, String>,
        body: ByteArray,
        method: String
    ): NetHttpClient {
        urlConnection.apply {
            headers.onEach {
                setRequestProperty(it.key, it.value)
            }
            requestMethod = method
            doOutput = true
            connect()
        }.run {
            outputStream.write(body)
            outputStream.flush()
        }
        return this
    }

    actual override fun getResponse(): ByteArray {
        return urlConnection.inputStream.readBytes()
    }

    actual override fun finalize() {
        urlConnection.disconnect()
    }
}