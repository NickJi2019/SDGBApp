package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRate(
    @SerialName("musicId") val musicId: Int,
    @SerialName("level") val level: Int,
    @SerialName("romVersion") val romVersion: UInt,
    @SerialName("achievement") val achievement: UInt
)
