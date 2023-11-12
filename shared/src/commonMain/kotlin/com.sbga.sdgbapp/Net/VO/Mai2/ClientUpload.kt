package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientUpload(
    @SerialName("orderId") val orderId: Int,
    @SerialName("divNumber") val divNumber: Int,
    @SerialName("divLength") val divLength: Int,
    @SerialName("divData") val divData: String,
    @SerialName("placeId") val placeId: Int,
    @SerialName("clientId") val clientId: String,
    @SerialName("uploadDate") val uploadDate: String,
    @SerialName("fileName") val fileName: String
)
