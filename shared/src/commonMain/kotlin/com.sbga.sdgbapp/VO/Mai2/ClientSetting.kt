package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientSetting(
    @SerialName("placeId") val placeId: Int,
    @SerialName("clientId") val clientId: String,
    @SerialName("placeName") val placeName: String,
    @SerialName("regionId") val regionId: Int,
    @SerialName("regionName") val regionName: String,
    @SerialName("bordId") val bordId: String,
    @SerialName("romVersion") val romVersion: Int,
    @SerialName("isDevelop") val isDevelop: Boolean,
    @SerialName("isAou") val isAou: Boolean
)
