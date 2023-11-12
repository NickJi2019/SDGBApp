package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserLoginBonus(
    @SerialName("bonusId") val bonusId: Int,
    @SerialName("point") val point: UInt,
    @SerialName("isCurrent") val isCurrent: Boolean,
    @SerialName("isComplete") val isComplete: Boolean
)
