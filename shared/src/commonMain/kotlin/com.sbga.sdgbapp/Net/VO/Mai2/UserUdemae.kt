package com.sbga.sdgbapp.Net.VO.Mai2


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserUdemae(
    @SerialName("rate") val rate: Int,
    @SerialName("maxRate") val maxRate: Int,
    @SerialName("classValue") val classValue: Int,
    @SerialName("maxClassValue") val maxClassValue: Int,
    @SerialName("totalWinNum") val totalWinNum: UInt,
    @SerialName("totalLoseNum") val totalLoseNum: UInt,
    @SerialName("maxWinNum") val maxWinNum: UInt,
    @SerialName("maxLoseNum") val maxLoseNum: UInt,
    @SerialName("winNum") val winNum: UInt,
    @SerialName("loseNum") val loseNum: UInt,
    @SerialName("npcTotalWinNum") val npcTotalWinNum: UInt,
    @SerialName("npcTotalLoseNum") val npcTotalLoseNum: UInt,
    @SerialName("npcMaxWinNum") val npcMaxWinNum: UInt,
    @SerialName("npcMaxLoseNum") val npcMaxLoseNum: UInt,
    @SerialName("npcWinNum") val npcWinNum: UInt,
    @SerialName("npcLoseNum") val npcLoseNum: UInt
)
