package com.sbga.sdgbapp.Utility

import kotlinx.cinterop.*
import platform.CFNetwork.*
import kotlinx.coroutines.*
import kotlinx.atomicfu.*
import platform.CoreFoundation.*
import platform.Foundation.*
import platform.UIKit.UIRectEdgeLeft
import platform.darwin.NSObject

@OptIn(ExperimentalForeignApi::class)
actual open class NetHttpClient : INetHttpClient {

    private val url:String
    private val urlSession: NSURLSession

    actual constructor(url: String) {
        this.url = url
        log.info(7)
        this.urlSession = NSURLSession.sessionWithConfiguration(
            NSURLSessionConfiguration.ephemeralSessionConfiguration,
            delegate = trustAllCredentialDelegate,
            delegateQueue = null
        )

    }
    actual override fun requestAsync(
        header: Map<String, String>?,
        body: ByteArray,
        method: String,
        completion: (ByteArray?) -> Unit
    ) {
        NSMutableURLRequest(NSURL.URLWithString(url)?:throw Exception("null return")).apply {
            setHTTPMethod(method)
            if (method == "POST") {
                setHTTPBody(body.toNSData())
            }
            allHTTPHeaderFields = (header ?: mapOf()) as Map<Any?, String>
        }.let {
            urlSession.dataTaskWithRequest(it) { responseBody: NSData?, responeseStatus: NSURLResponse?, error: NSError? ->
                if (error != null) {
                    // 请求失败，处理错误
                    log.error("Error: ${error.localizedFailureReason}")
                    log.error(error.localizedDescription)
                    log.error(error.localizedRecoveryOptions)
                    log.error(error.localizedRecoverySuggestion)
                    throw Exception(error.localizedFailureReason)
                } else {
                    // 请求成功，处理响应
                    log.info("got response")
                    log.info("responseStatus:",(responeseStatus as NSHTTPURLResponse).statusCode)
                    log.info(responeseStatus.allHeaderFields)
                }
                completion(responseBody?.toByteArray())
            }.resume()
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    actual override fun requestSync(header: Map<String, String>?, body: ByteArray, method: String): ByteArray? {
        val completed = CompletableDeferred<ByteArray?>()
        requestAsync(header, body, method) {
            completed.complete(it)
        }
        runBlocking { completed.await() }
        return completed.getCompleted()
    }

    /*
    * 释放资源 / release resources
    *
    * ** 重要提示：除非有意为之，请不要在调用异步请求`requestAsync`后立即调用此方法 **
    * ** Important: Do not call this method immediately after calling the asynchronous request `requestAsync` unless you mean to do so **
     */
    actual override fun finalize() {
        urlSession.invalidateAndCancel()
    }

    companion object{
        fun NSData.toByteArray(): ByteArray = memScoped {
            this@toByteArray.bytes?.readBytes(this@toByteArray.length.convert()) ?: throw Exception("NSData is null")
        }
        fun ByteArray.toNSData(): NSData = memScoped {
            return NSData.dataWithBytes(this@toNSData.toCValues().ptr,this@toNSData.size.convert())
        }
        object trustAllCredentialDelegate: NSObject(), NSURLSessionDelegateProtocol {
            override fun URLSession(
                session: NSURLSession,
                didReceiveChallenge: NSURLAuthenticationChallenge,
                completionHandler: (NSURLSessionAuthChallengeDisposition, NSURLCredential?) -> Unit) {

                if (didReceiveChallenge.protectionSpace.authenticationMethod == NSURLAuthenticationMethodServerTrust) {
                    completionHandler(
                        NSURLSessionAuthChallengeUseCredential,
                        NSURLCredential.credentialForTrust(didReceiveChallenge.protectionSpace.serverTrust!!)
                    )
                } else {
                    completionHandler(NSURLSessionAuthChallengePerformDefaultHandling, null)
                }
            }
        }
    }
}