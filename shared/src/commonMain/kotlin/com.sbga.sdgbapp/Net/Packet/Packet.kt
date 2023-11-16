package com.sbga.sdgbapp.Net.Packet

import com.sbga.sdgbapp.Net.NetConfig
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Utility.*
import com.sbga.sdgbapp.VO.VOSerializer
import io.ktor.http.*


class Packet {
    lateinit var baseUrl: String
    lateinit var client: NetHttpClient
    lateinit var query: NetQuery<*, *>


    suspend inline fun <reified T0 : VOSerializer, reified T1 : VOSerializer> create(query: NetQuery<T0, T1>): Packet {
        this.query = query
        this.client = NetHttpClient("https://maimai-gm.wahlap.com:42081/Maimai2Servlet/${obfuscator(query.api)}")
        val response = this.client.request(
            CipherAES.encrypt(query.getRequest<T0>()).encodeToByteArray(),
            getUserAgent(query),
            HttpMethod.Post
        )
        query.setResponse<T1>(CipherAES.decrypt(response).decodeToString())
        return this
    }

    companion object {
        fun obfuscator(str: String): String {
            var endpoint = stringToHex(MD5.md5(str + obfuscateParam))
            if (endpoint.length == 31) endpoint = "0$endpoint"
            return endpoint
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

        fun getUserAgent(query: NetQuery<*, *>): String {
            if (query.UserId != 0uL) {
                return "${Packet.obfuscator(query.api)}#${query.UserId}"
            }
            return Packet.obfuscator(query.api) + "#" + NetConfig.clientId
        }

        private val obfuscateParam: String = "SX2bTFe8"
    }
}