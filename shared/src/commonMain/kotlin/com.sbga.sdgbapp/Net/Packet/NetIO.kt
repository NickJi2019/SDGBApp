package com.sbga.sdgbapp.Net.Packet

import com.sbga.sdgbapp.ConfigManager
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Net.VO.VOSerializer
import com.sbga.sdgbapp.Utility.Extensions.decrypt
import com.sbga.sdgbapp.Utility.Extensions.deflate
import com.sbga.sdgbapp.Utility.Extensions.encrypt
import com.sbga.sdgbapp.Utility.Extensions.inflate
import com.sbga.sdgbapp.Utility.MD5
import com.sbga.sdgbapp.Utility.NetHttpsClient


object NetIO {
    @OptIn(ExperimentalStdlibApi::class)
    inline fun <reified T0 : VOSerializer,reified T1 : VOSerializer> sendRequest(data:NetQuery<T0,T1>):NetQuery<T0,T1> {
        val client = NetHttpsClient(ConfigManager.maiApiURL + getEndpoint(data)).apply {
            headers = mapOf(
                "Content-Type" to "application/json",
                "User-Agent" to getUserAgent(data),
                "charset" to "UTF-8",
                "Mai-Encoding" to "1.30",
                "Content-Encoding" to "deflate",
                "Expect" to "100-continue",
                "Accept" to ""
            )
            request(body = data.getRequest<T0>().encodeToByteArray().encrypt().deflate(), method = "GET")
            data.setResponse<T1>(getResponse().inflate().decrypt().decodeToString())
            finalize()
        }
        return data
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun obfuscator(str: String): String {
        var endpoint = MD5.md5(str + ConfigManager.SecureManager.obfuscate.obfuscateParam).toHexString()
        if (endpoint.length == 31) endpoint = "0$endpoint"
        return endpoint
    }

    fun getEndpoint(query: NetQuery<*, *>): String {
        return obfuscator(query.api)
    }
    fun getUserAgent(query: NetQuery<*, *>): String {
        if (query.UserId != 0uL) {
            return "${getEndpoint(query)}#${query.UserId}"
        }
        return "${getEndpoint(query)}#${ConfigManager.clientId}"
    }


}