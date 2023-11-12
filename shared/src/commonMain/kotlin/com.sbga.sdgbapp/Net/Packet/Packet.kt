package com.sbga.sdgbapp.Net.Packet

import com.sbga.sdgbapp.Net.NetConfig
import com.sbga.sdgbapp.Net.NetPacketUtil
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Utility.MD5
import com.sbga.sdgbapp.Utility.NetHttpClient
import com.sbga.sdgbapp.VO.VOSerializer
import io.ktor.http.*
import io.ktor.util.*


class Packet {
    lateinit var baseUrl: String
    lateinit var client: NetHttpClient
    lateinit var query: NetQuery<*, *>

    var httpStatus: Int = -1

    var retryCount: Int = 0
    var time: Float = 0f


    suspend inline fun <reified T0 : VOSerializer, reified T1 : VOSerializer> create(
        query: NetQuery<T0, T1>,
        url: String? = null
    ): Boolean {
        this.baseUrl = url ?: "https://maimai-gm.wahlap.com:42081/Maimai2Servlet/"
        this.query = query
        this.retryCount = 0
        this.time = 0f

        return try {
            this.client = NetHttpClient(this.baseUrl + obfuscator(query.api))
            this.client.timeOutInMSec = NetConfig.timeoutInMSec
            this.procImpl<T0, T1>()
            true
        } catch (_: Exception) {
            false
        }
    }

    @OptIn(InternalAPI::class)
    suspend inline fun <reified T0 : VOSerializer, reified T1 : VOSerializer> procImpl() {
        val request = this.query.getRequest<T0>()
        this.client.request(request.encodeToByteArray(), NetPacketUtil.getUserAgent(this.query), HttpMethod.Post)
        val byteArray = ArrayList<Byte>()
        while (this.client.httpResponse.content.availableForRead > 0) {
            byteArray.add(
                this
                    .client
                    .httpResponse
                    .content
                    .readByte()
            )
        }
        this.query.setResponse<T1>(this.client.httpResponse.content.toByteArray().decodeToString())
    }

    companion object {
        fun obfuscator(str: String): String {
            val hashArray = MD5.md5(str + obfuscateParam)
            return stringToHex(hashArray)
        }

        fun stringToHex(input: ByteArray): String {
            val hexChars = "0123456789abcdef"
            val result = StringBuilder()

            for (char in input) {
                val highNibble = char.toInt() ushr 4 and 0xF
                val lowNibble = char.toInt() and 0xF
                result.append(hexChars[highNibble])
                result.append(hexChars[lowNibble])
            }

            return result.toString()
        }


        private val obfuscateParam: String = "SX2bTFe8"
    }
}