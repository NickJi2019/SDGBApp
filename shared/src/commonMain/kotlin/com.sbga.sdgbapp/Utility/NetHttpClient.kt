package com.sbga.sdgbapp.Utility

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.content.*
import io.ktor.http.*
import io.ktor.util.*
import kotlin.io.encoding.ExperimentalEncodingApi


@OptIn(ExperimentalEncodingApi::class)
class NetHttpClient {

    lateinit var httpClient: HttpClient
    lateinit var httpResponse: HttpResponse
    lateinit var url: String

    constructor(url: String) {
        this.url = url
        httpClient = HttpClient {
        }
    }

    @OptIn(InternalAPI::class)
    suspend fun request(bytes: ByteArray, userAgent: String, method: HttpMethod): Boolean {
        var flag: Boolean = false
        try {
            val encryptedBytes = CipherAES.encrypt(bytes)

            httpResponse = httpClient.get {
                url(Url(this@NetHttpClient.url))
                this.method = method
                contentType(ContentType.Application.Json)
                header("User-Agent", userAgent)
                header("charset", "UTF-8")
                if (encryptedBytes.isNotEmpty()) {
                    header("Content-Encoding", "deflate")
                    header("Mai-Encoding", "1.30")
                    body = TextContent(encryptedBytes.toString(), ContentType.Application.Json)
                    flag = true
                } else {
                    body = TextContent("", ContentType.Application.Json)
                    flag = true
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return flag
    }


    lateinit var webException: Exception

    lateinit var error: String

    var timeOutInMSec: UInt = 60000u
}