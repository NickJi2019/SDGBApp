package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserCharacter(
    @SerialName("characterId") val characterId: Int,
    @SerialName("level") val level: UInt,
    @SerialName("awakening") val awakening: UInt,
    @SerialName("useCount") val useCount: UInt
)
