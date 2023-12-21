package com.sbga.sdgbapp.Net.VO

import com.sbga.sdgbapp.Utility.Extensions.deserialize
import com.sbga.sdgbapp.Utility.Extensions.serialize

class NetQuery<T0 : VOSerializer, T1 : VOSerializer> {
    var api: String
    var UserId: ULong
    var request: T0?
    var response: T1?
    constructor(api: String, userId: ULong) {
        this.api = api + "MaimaiChn"
        this.UserId = userId
        this.request = null
        this.response = null
    }



    inline fun <reified T : VOSerializer> getRequest(): String {
        return (this.request as T).serialize<T>()
    }

    inline fun <reified T : VOSerializer> setResponse(str: String) {
        this.response = str.deserialize<T>() as T1
    }

}
