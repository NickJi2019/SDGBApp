package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameTournamentMusic(
    @SerialName("tournamentId") val tournamentId: Int,
    @SerialName("musicId") val musicId: Int,
    @SerialName("level") val level: Int,
    @SerialName("isFirstLock") val isFirstLock: Boolean
)
