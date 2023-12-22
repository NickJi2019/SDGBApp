package com.sbga.sdgbapp.Utility

import java.net.URL
import java.security.SecureRandom
import javax.net.ssl.*

actual class NetHttpsClient : NetHttpClient {

    private var urlConnection:HttpsURLConnection

    actual constructor(url: String) : super(url) {
        urlConnection = URL(url).openConnection() as HttpsURLConnection
    }

    actual override fun request(header: Map<String, String>?, body: ByteArray, method: String): NetHttpClient {
        urlConnection.apply {
            header?.onEach { setRequestProperty(it.key, it.value) }
            sslSocketFactory = SSLContext.getInstance("SSL").apply {
                init(null, arrayOf<TrustManager>(object : X509TrustManager {
                    override fun checkClientTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {}
                    override fun checkServerTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {}
                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf() }), SecureRandom())
            }.socketFactory
            requestMethod = method
            hostnameVerifier = HostnameVerifier { _, _ -> true }
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


}