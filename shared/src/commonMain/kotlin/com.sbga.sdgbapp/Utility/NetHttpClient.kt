package com.sbga.sdgbapp.Utility

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.*
import io.ktor.content.*
import io.ktor.http.*


class NetHttpClient {

    lateinit var httpClient: HttpClient
    var httpResponse: HttpResponse? = null
    lateinit var url: String

    constructor(url: String) {
        this.url = url
        httpClient = HttpClient {
            install(HttpTimeout) {
                requestTimeoutMillis = timeOutInMSec.toLong()
            }
        }
    }

    suspend fun request(data: ByteArray, userAgent: String, method: HttpMethod): ByteArray {
        try {
            this.httpResponse = httpClient.request {
                url(this@NetHttpClient.url)
                println(this@NetHttpClient.url)
                this.method = method
                header("Content-Type", "application/json")
                header("User-Agent", userAgent)
                header("charset", "UTF-8")
                header("Mai-Encoding", "1.31")
                header("Content-Encoding", "deflate")
                header("Expect", "100-continue")
                header("Accept", "")
                ByteArrayContent(Compressor.deflate(data), ContentType.Application.Json)
            }
            println(this.httpResponse!!.request.url)
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
        return Compressor.inflate(httpResponse!!.body())
    }


    lateinit var webException: Exception

    lateinit var error: String

    var timeOutInMSec: UInt = 60000u
}