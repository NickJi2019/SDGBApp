package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserLoginRequestVO(
    @SerialName("dateTime") val dateTime: String,
    @SerialName("genericFlag") val genericFlag: Int,
    @SerialName("clientId") val clientId: String,
    @SerialName("regionId") val regionId: Int,
    @SerialName("accessCode") val accessCode: String,
    @SerialName("userId") val userId: ULong,
    @SerialName("isContinue") val isContinue: Boolean,
    @SerialName("placeId") val placeId: Int
) : VOSerializer()
