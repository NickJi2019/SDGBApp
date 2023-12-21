package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRecommendRateMusic(
    @SerialName("musicId") val musicId: Int,
    @SerialName("level") val level: Int,
    @SerialName("averageAchievement") val averageAchievement: Int
)
