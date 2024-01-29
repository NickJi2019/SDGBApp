package com.sbga.sdgbapp.Utility

import kotlinx.coroutines.*
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
                    null, arrayOf<TrustManager>(trustAllCertificateManager), SecureRandom()
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


    /*
    * 释放资源 / release resources
    *
    * ** 重要提示：除非有意为之，请不要在调用异步请求`requestAsync`后立即调用此方法 **
    * ** Important: Do not call this method immediately after calling the asynchronous request `requestAsync` unless you mean to do so **
    */
    actual override fun finalize() {
        urlConnection.disconnect()
    }

    companion object{
        object trustAllCertificateManager: X509TrustManager {
            override fun checkClientTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {}
            override fun checkServerTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {}
            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf() }
    }
}