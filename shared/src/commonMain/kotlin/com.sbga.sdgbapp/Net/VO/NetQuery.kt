package com.sbga.sdgbapp.Net.VO

import com.sbga.sdgbapp.Utility.JsonUtil.toClass
import com.sbga.sdgbapp.Utility.JsonUtil.toJsonString
import com.sbga.sdgbapp.VO.VOSerializer

class NetQuery<T0 : VOSerializer, T1 : VOSerializer> {
    val api: String
    val UserId: ULong
    var request: Any?
    var response: Any?

    constructor(api: String, userId: ULong, requestVO: T0? = null) {
        this.api = api + "MaimaiChn"
        this.UserId = userId
        this.request = requestVO
        this.response = null
    }

    inline fun <reified T : VOSerializer> getRequest(): String {
        return toJsonString<T>(this.request as T)
    }


    inline fun <reified T : VOSerializer> getResponse(): T {
        return response as T
    }
    inline fun <reified T : VOSerializer> setResponse(str: String) {
        if (str.isEmpty()) {
            throw Exception("json string is empty")
        }
        this.response = str.toClass<T>()
    }
}