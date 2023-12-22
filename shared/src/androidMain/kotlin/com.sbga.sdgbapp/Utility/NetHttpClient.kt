package com.sbga.sdgbapp.Utility

import java.net.HttpURLConnection
import java.net.URL

actual open class NetHttpClient : INetHttpClient {
    private var urlConnection:HttpURLConnection
    var result:ByteArray? = null

    actual constructor(url: String) {
        urlConnection = URL(url).openConnection() as HttpURLConnection
    }

    actual override var headers: Map<String, String> = mapOf()

    actual override fun request(header: Map<String, String>?, body: ByteArray, method: String): NetHttpClient {
        urlConnection.apply {
            header?.onEach { setRequestProperty(it.key, it.value) }
            requestMethod = method
            doOutput = true
            connect()
        }.run {
            outputStream.write(body)
            outputStream.flush()
            outputStream.close()
            result = inputStream.readBytes()
            inputStream.close()
        }
        return this
    }

    actual override fun getResponse(): ByteArray {
        return result?:throw Exception("No response")
    }

    actual override fun finalize() {
        urlConnection.disconnect()
    }
}