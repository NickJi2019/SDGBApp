package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientBookkeeping(
    @SerialName("placeId") val placeId: Int,
    @SerialName("clientId") val clientId: String,
    @SerialName("updateDate") val updateDate: String,
    @SerialName("creditSetting0") val creditSetting0: Int,
    @SerialName("creditSetting1") val creditSetting1: Int,
    @SerialName("creditSetting2") val creditSetting2: Int,
    @SerialName("credits1P") val credits1P: Int,
    @SerialName("credits2P") val credits2P: Int,
    @SerialName("creditsFreedom") val creditsFreedom: Int,
    @SerialName("creditsTicket") val creditsTicket: Int,
    @SerialName("creditCoin") val creditCoin: Int,
    @SerialName("creditService") val creditService: Int,
    @SerialName("creditEmoney") val creditEmoney: Int,
    @SerialName("timeTotal") val timeTotal: Int,
    @SerialName("timeTotalPlay") val timeTotalPlay: Int,
    @SerialName("timeLongest1P") val timeLongest1P: Int,
    @SerialName("timeShortest1P") val timeShortest1P: Int,
    @SerialName("timeLongest2P") val timeLongest2P: Int,
    @SerialName("timeShortest2P") val timeShortest2P: Int,
    @SerialName("timeLongestFreedom") val timeLongestFreedom: Int,
    @SerialName("timeShortestFreedom") val timeShortestFreedom: Int,
    @SerialName("newFreeUserNum") val newFreeUserNum: Int,
    @SerialName("tutorialPlay") val tutorialPlay: Int,
    @SerialName("play1PNum") val play1PNum: Int,
    @SerialName("play2PNum") val play2PNum: Int,
    @SerialName("playFreedomNum") val playFreedomNum: Int,
    @SerialName("aimeLoginNum") val aimeLoginNum: Int,
    @SerialName("guestLoginNum") val guestLoginNum: Int,
    @SerialName("regionId") val regionId: Int,
    @SerialName("playCount") val playCount: Int,
    @SerialName("coinToCredit") val coinToCredit: Int
)