package com.sbga.sdgbapp.Utility

import java.net.URL
import javax.net.ssl.*

actual class NetHttpsClient : NetHttpClient {

    private var urlConnection:HttpsURLConnection

    actual constructor(url: String) : super(url) {
        urlConnection = URL(url).openConnection() as HttpsURLConnection
    }

    actual override fun request(header: Map<String, String>?, body: ByteArray, method: String): NetHttpClient {
        urlConnection.apply {
            header?.onEach { setRequestProperty(it.key, it.value) }

//            val keyStore = KeyStore.getInstance(KeyStore.getDefaultType()).apply {
//                load(null, null)
//                setCertificateEntry("ca", CertificateFactory.getInstance("X.509").generateCertificate(ByteArrayInputStream(ConfigManager.SecureManager.SSLCertificate.serverCertificate.encodeToByteArray())))
//            }
//
//            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()).apply {
//                init(keyStore)
//            }.trustManagers

            sslSocketFactory = SSLContext
                .getDefault().socketFactory
//                .getInstance("SSL").apply { init(
//                    null, arrayOf<TrustManager>(object : X509TrustManager {
//                    override fun checkClientTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {}
//                    override fun checkServerTrusted(p0: Array<out java.security.cert.X509Certificate>?, p1: String?) {}
//                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf() }), SecureRandom()
//                )
//            }.socketFactory
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