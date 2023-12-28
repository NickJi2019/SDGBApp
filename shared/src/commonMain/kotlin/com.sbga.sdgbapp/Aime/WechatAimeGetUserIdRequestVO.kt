package com.sbga.sdgbapp.Aime

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WechatAimeGetUserIdRequestVO (
    @SerialName("qrCode") var qrCode: String,
    @SerialName("openGameID") var openGameID: String ,
    @SerialName("chipID") var chipID: String,
    @SerialName("key") var key: String,
    @SerialName("timestamp") var timestamp: String,
): VOSerializer()