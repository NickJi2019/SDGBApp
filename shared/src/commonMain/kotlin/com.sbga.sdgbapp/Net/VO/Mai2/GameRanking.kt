package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameRanking(
    @SerialName("id") val id: Long,
    @SerialName("point") val point: Long,
    @SerialName("userName") val userName: String
)
