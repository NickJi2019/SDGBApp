package com.sbga.sdgbapp.Utility

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.*
import java.security.SecureRandom
import javax.net.ssl.*

actual open class NetHttpClient : INetHttpClient {
    private var urlConnection:HttpURLConnection

    actual constructor(url: String) {
        log.info("ip: ${InetAddress.getByName(URL(url).host).hostAddress}")

        val url = URL(url)

        if (url.protocol == "https") {
            urlConnection = url.openConnection() as HttpsURLConnection
            (urlConnection as HttpsURLConnection).apply {
                sslSocketFactory = SSLContext.getInstance("SSL").apply { init(
                    null, arrayOf<TrustManager>(object : X509TrustManager {
                        override fun checkClientTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {}
                        override fun checkServerTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {}
                        override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf() }), SecureRandom()
                ) }.socketFactory
                hostnameVerifier = HostnameVerifier { _, _ -> true }
            }
        }else if (url.protocol == "http") {
            urlConnection = url.openConnection() as HttpURLConnection
        }else{
            throw Exception("Unsupported protocol")
        }
    }

    actual override fun requestSync(header: Map<String, String>?, body: ByteArray, method: String): ByteArray? {
        log.info(body.decodeToString())
        urlConnection.apply {
            header?.onEach { setRequestProperty(it.key, it.value) }
            requestMethod = method
            doOutput = true
            connect()
        }.run {
            if(requestMethod == "POST"){
                outputStream.write(body)
                outputStream.flush()
                outputStream.close()
            }
            val result = inputStream.readBytes()
            inputStream.close()
            return result
        }
    }

    actual override fun requestAsync(
        header: Map<String, String>?,
        body: ByteArray,
        method: String,
        completion: (ByteArray?) -> Unit
    ): Unit {
        GlobalScope.launch {
            completion(requestSync(header, body, method))
        }
    }

    actual override fun finalize() {
        urlConnection.disconnect()
    }
}