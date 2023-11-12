package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserChargelog(
    @SerialName("chargeId") val chargeId: Int,
    @SerialName("price") val price: Int,
    @SerialName("purchaseDate") val purchaseDate: String,
    @SerialName("playCount") val playCount: Int,
    @SerialName("playerRating") val playerRating: Int,
    @SerialName("placeId") val placeId: Int,
    @SerialName("regionId") val regionId: Int,
    @SerialName("clientId") val clientId: String
)
