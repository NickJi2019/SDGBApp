package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserMap(
    @SerialName("mapId") val mapId: Int,
    @SerialName("distance") val distance: UInt,
    @SerialName("isLock") val isLock: Boolean,
    @SerialName("isClear") val isClear: Boolean,
    @SerialName("isComplete") val isComplete: Boolean
)
