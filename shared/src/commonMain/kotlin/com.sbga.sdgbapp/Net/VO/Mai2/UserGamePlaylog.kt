package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserGamePlaylog(
    @SerialName("playlogId") val playlogId: ULong,
    @SerialName("version") val version: String,
    @SerialName("playDate") val playDate: String,
    @SerialName("playMode") val playMode: Int,
    @SerialName("useTicketId") val useTicketId: Int,
    @SerialName("playCredit") val playCredit: Int,
    @SerialName("playTrack") val playTrack: Int,
    @SerialName("clientId") val clientId: String,
    @SerialName("isPlayTutorial") val isPlayTutorial: Boolean,
    @SerialName("isEventMode") val isEventMode: Boolean,
    @SerialName("isNewFree") val isNewFree: Boolean,
    @SerialName("playCount") val playCount: Int,
    @SerialName("playSpecial") val playSpecial: Int,
    @SerialName("playOtherUserId") val playOtherUserId: ULong
)
