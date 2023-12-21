package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameEvent(
    @SerialName("type") val type: Int,
    @SerialName("id") val id: Int,
    @SerialName("startDate") val startDate: String,
    @SerialName("endDate") val endDate: String
)
