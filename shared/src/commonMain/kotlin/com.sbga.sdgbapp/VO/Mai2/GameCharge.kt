package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameCharge(
    @SerialName("orderId") val orderId: Int,
    @SerialName("chargeId") val chargeId: Int,
    @SerialName("price") val price: Int,
    @SerialName("startDate") val startDate: String,
    @SerialName("endDate") val endDate: String
)
