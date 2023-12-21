package com.sbga.sdgbapp.Net.VO.Mai2


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserPhoto(
    @SerialName("orderId") val orderId: Int,
    @SerialName("userId") val userId: ULong,
    @SerialName("divNumber") val divNumber: Int,
    @SerialName("divLength") val divLength: Int,
    @SerialName("divData") val divData: String,
    @SerialName("placeId") val placeId: Int,
    @SerialName("clientId") val clientId: String,
    @SerialName("uploadDate") val uploadDate: String,
    @SerialName("playlogId") val playlogId: ULong,
    @SerialName("trackNo") val trackNo: Int
)
