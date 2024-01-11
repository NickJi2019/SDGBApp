package com.sbga.sdgbapp.Utility

import kotlinx.cinterop.*
import platform.CFNetwork.*
import kotlinx.coroutines.*
import kotlinx.atomicfu.*
import platform.CoreFoundation.*
import platform.darwin.UInt8Var
import platform.posix.free
import cocoapods.AFNetworking.*
import platform.Foundation.*

@OptIn(ExperimentalForeignApi::class)
actual open class NetHttpClient : INetHttpClient {
    private val url:String
    private var responseData: ByteArray? = null
    actual override var headers: Map<String, String> = mapOf()
    actual constructor(url: String) {
        this.url = url
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private suspend fun requestWithSuspend(header: Map<String, String>?, body: ByteArray, method: String) = coroutineScope {
        log.info("requestWithSuspend")
        val manager = AFHTTPSessionManager.manager()

        manager.securityPolicy = AFSecurityPolicy.policyWithPinningMode(AFSSLPinningMode.AFSSLPinningModeNone).apply {
            allowInvalidCertificates = true
            validatesDomainName = false
        }
        val response = CompletableDeferred<ByteArray?>()

        val request = NSMutableURLRequest.requestWithURL(NSURL.URLWithString(url)?:throw Exception("null return")).apply {
            setHTTPMethod(method)
            setHTTPBody(body.toNSData())
            header?.forEach { setValue(it.value, forHTTPHeaderField = it.key) }
        }

        log.info("request created")
        log.info("request start to send")
        manager.dataTaskWithRequest(
            request,
            {log.info("Upload Progress: ${it?.fractionCompleted}")},
            {log.info("Download Progress: ${it?.fractionCompleted}")},
            completionHandler = { responseStatus, responseBody, error ->
                log.info("response received")
                log.info("responseStatus:",(responseStatus as NSHTTPURLResponse).statusCode)
                log.info(responseStatus.allHeaderFields)
                if (error != null) {
                    // 请求失败，处理错误
                    log.error("Error: ${error.localizedDescription}")
                } else {
                    log.info("got response")
                    // 请求成功，处理响应
                    val responseByteArray = (responseBody as? NSData)?.toByteArray()
                    response.complete(responseByteArray)
                }
            }
        ).resume()
        log.info("request sent")
        response.await()
        log.info("requestWithSuspend end")
        responseData = response.getCompleted()
    }

    actual override fun request(header: Map<String, String>?, body: ByteArray, method: String): NetHttpClient {
        log.info("request")
        runBlocking {
            requestWithSuspend(header,body,method)
        }
        log.info("request end")
        return this
    }



    actual override fun getResponse(): ByteArray {
        log.info("getResponse")
        return responseData?:throw Exception("No response data")
    }
    actual override fun finalize() {
    }

    companion object{
        fun NSData.toByteArray(): ByteArray = memScoped {
            this@toByteArray.bytes?.readBytes(this@toByteArray.length.convert()) ?: throw Exception("NSData is null")
        }
        fun ByteArray.toNSData(): NSData = memScoped {
            return NSData.dataWithBytes(this@toNSData.toCValues().ptr,this@toNSData.size.convert())
        }
    }
}