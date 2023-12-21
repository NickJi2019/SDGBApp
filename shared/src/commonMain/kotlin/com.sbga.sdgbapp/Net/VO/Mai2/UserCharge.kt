package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserCharge(
    @SerialName("chargeId") val chargeId: Int,
    @SerialName("stock") val stock: Int,
    @SerialName("purchaseDate") val purchaseDate: String,
    @SerialName("validDate") val validDate: String
)
