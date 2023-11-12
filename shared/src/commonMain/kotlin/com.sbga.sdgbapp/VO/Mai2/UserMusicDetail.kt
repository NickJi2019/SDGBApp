package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.sbga.sdgbapp.DB.*

@Serializable
data class UserMusicDetail(
    @SerialName("musicId") val musicId: Int,
    @SerialName("level") val level: MusicDifficultyID,
    @SerialName("playCount") val playCount: UInt,
    @SerialName("achievement") val achievement: UInt,
    @SerialName("comboStatus") val comboStatus: PlayComboflagID,
    @SerialName("syncStatus") val syncStatus: PlaySyncflagID,
    @SerialName("deluxscoreMax") val deluxscoreMax: UInt,
    @SerialName("scoreRank") val scoreRank: MusicClearrankID,
    @SerialName("extNum1") val extNum1: UInt
)
