package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserCard(
    @SerialName("cardId") val cardId: Int,
    @SerialName("cardTypeId") val cardTypeId: Int,
    @SerialName("charaId") val charaId: Int,
    @SerialName("mapId") val mapId: Int,
    @SerialName("startDate") val startDate: String,
    @SerialName("endDate") val endDate: String
)
