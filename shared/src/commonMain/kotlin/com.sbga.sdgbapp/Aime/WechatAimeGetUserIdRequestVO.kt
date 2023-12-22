package com.sbga.sdgbapp.Aime

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class WechatAimeGetUserIdRequestVO (
    @SerialName("chipID") var chipID: String,
    @SerialName("openGameID") var openGameID: String ,
    @SerialName("key") var key: String,
    @SerialName("qrCode") var qrCode: String,
    @SerialName("timestamp") var timestamp: String,
): VOSerializer()