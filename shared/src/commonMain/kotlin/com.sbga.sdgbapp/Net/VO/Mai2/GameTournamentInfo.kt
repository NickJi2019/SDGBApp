package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameTournamentInfo(
    @SerialName("tournamentId") val tournamentId: Int,
    @SerialName("tournamentName") val tournamentName: String,
    @SerialName("rankingKind") val rankingKind: Int,
    @SerialName("scoreType") val scoreType: Int,
    @SerialName("noticeStartDate") val noticeStartDate: String,
    @SerialName("noticeEndDate") val noticeEndDate: String,
    @SerialName("startDate") val startDate: String,
    @SerialName("endDate") val endDate: String,
    @SerialName("entryStartDate") val entryStartDate: String,
    @SerialName("entryEndDate") val entryEndDate: String,
    @SerialName("gameTournamentMusicList") val gameTournamentMusicList: Array<GameTournamentMusic>
)
