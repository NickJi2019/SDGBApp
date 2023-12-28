package com.sbga.sdgbapp.Utility

import kotlinx.cinterop.*
import platform.CFNetwork.*
import platform.CoreFoundation.*
import platform.Foundation.NSMutableData
import platform.Foundation.appendBytes
import platform.darwin.UInt8Var
import platform.posix.free


@OptIn(ExperimentalForeignApi::class)
actual open class NetHttpClient : INetHttpClient {
    private val url:CFStringRef
    private var responseData: ByteArray? = null
    actual override var headers: Map<String, String> = mapOf()
    actual constructor(url: String) {
        this.url = url.toCFString()
    }
    actual override fun request(header: Map<String, String>?, body: ByteArray, method: String): NetHttpClient {
        memScoped {
            println("create request")
            val request = CFHTTPMessageCreateRequest(
                null,
                method.toCFString(),
                url.toCFURL(),
                kCFHTTPVersion1_1
            ).apply {
                CFHTTPMessageSetBody(this, body.decodeToString().toCFData())
                header?.forEach { CFHTTPMessageSetHeaderFieldValue(this, it.key.toCFString(), it.value.toCFString()) }
            }
            CFReadStreamCreateForHTTPRequest(null, request).let {

                val sslSettings = mapOf(
                    kCFStreamSSLValidatesCertificateChain to kCFBooleanFalse as CPointer<*>,
                    kCFStreamSSLLevel to kCFStreamSocketSecurityLevelNegotiatedSSL as CPointer<*>
                ).toCFDictionary()

                CFReadStreamSetProperty(it, kCFStreamPropertySSLSettings, sslSettings)

                if (it != null && CFReadStreamOpen(it)) {
                    val data = NSMutableData()
                    val buffer = allocArray<UInt8Var>(1024)
                    var readBytes: Int
                    do {
                        readBytes = CFReadStreamRead(it, buffer, 1024).toInt()
                        if (readBytes > 0) {
                            data.appendBytes(buffer, readBytes.toULong())
                        }else if(readBytes < 0){
                            throw Exception("CFReadStreamGetError domain:${CFReadStreamGetError(it).ptr.pointed.domain} code:${CFReadStreamGetError(it).ptr.pointed.error}")
                        }
                    } while (readBytes > 0)
                    responseData = data.mutableBytes?.readBytes(data.length.toInt())

                    data.finalize()
                    free(buffer)
                } else {
                    throw Exception("CFReadStreamGetError domain:${CFReadStreamGetError(it).ptr.pointed.domain} code:${CFReadStreamGetError(it).ptr.pointed.error}")
                }
                CFRelease(it)
                CFRelease(request)
            }
        }
        return this
    }

    actual override fun getResponse(): ByteArray {
        println("getResponse")
        return responseData?:throw Exception("No response data")
    }
    actual override fun finalize() {
        CFRelease(url)
    }

    companion object{
        fun String.toCFString(): CFStringRef {
            return CFStringCreateWithCString(null, this, kCFStringEncodingUTF8)?:throw Exception("CFStringCreateWithCString failed")
        }

        fun CFStringRef.toCFURL(): CFURLRef {
            return CFURLCreateWithString(null, this, null)?:throw Exception("CFURLCreateWithString failed")
        }
        fun String.toCFData(): CFDataRef {
            return CFStringCreateExternalRepresentation(null, this.toCFString(), kCFStringEncodingUTF8, 0u)?:throw Exception("CFStringCreateExternalRepresentation failed")
        }
        fun Map<CFStringRef?, CPointer<*>>.toCFDictionary(): CFDictionaryRef {
            memScoped{
                val array1 = allocArray<COpaquePointerVar>(this@toCFDictionary.size)
                val array2 = allocArray<COpaquePointerVar>(this@toCFDictionary.size)
                var num = 0
                for (i in this@toCFDictionary) {
                    array1[num] = i.key
                    array2[num] = i.value
                    num++
                }
                return CFDictionaryCreate(null, array1, array2, this@toCFDictionary.size.convert(), null, null) ?: throw Exception(
                    "CFDictionaryCreate failed"
                )
            }
        }
    }
}