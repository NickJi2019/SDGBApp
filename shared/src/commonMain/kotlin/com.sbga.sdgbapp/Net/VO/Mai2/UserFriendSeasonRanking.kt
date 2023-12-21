package com.sbga.sdgbapp.Net.VO.Mai2


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserFriendSeasonRanking(
    @SerialName("seasonId") val seasonId: Int,
    @SerialName("point") val point: Int,
    @SerialName("rank") val rank: Int,
    @SerialName("rewardGet") val rewardGet: Boolean,
    @SerialName("userName") val userName: String,
    @SerialName("recordDate") val recordDate: String
)
