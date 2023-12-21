package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserScoreRanking(
    @SerialName("tournamentId") val tournamentId: Int,
    @SerialName("totalScore") val totalScore: Long,
    @SerialName("ranking") val ranking: Int,
    @SerialName("rankingDate") val rankingDate: String
)
