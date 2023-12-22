package com.sbga.sdgbapp.Aime

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class AimeResponseVO :VOSerializer(){
    @SerialName("errorID")  var errorID:Int = 0
    @SerialName("key")      var key: String = ""
    @SerialName("timestamp")var timestamp: String = ""
    @SerialName("userID")   var userID: Long = 0
}