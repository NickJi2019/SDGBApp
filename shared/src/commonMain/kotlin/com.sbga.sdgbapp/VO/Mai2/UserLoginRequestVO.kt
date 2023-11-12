package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserLoginRequestVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("accessCode") val accessCode: String,
    @SerialName("regionId") val regionId: Int,
    @SerialName("placeId") val placeId: Int,
    @SerialName("clientId") val clientId: String,
    @SerialName("dateTime") val dateTime: Long,
    @SerialName("isContinue") val isContinue: Boolean,
    @SerialName("genericFlag") val genericFlag: Int
) : VOSerializer()
