package com.sbga.sdgbapp.VO.Mai2


import com.sbga.sdgbapp.DB.MusicDifficultyID
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserGhost(
    @SerialName("name") val name: String,
    @SerialName("iconId") val iconId: Int,
    @SerialName("plateId") val plateId: Int,
    @SerialName("titleId") val titleId: Int,
    @SerialName("rate") val rate: Int,
    @SerialName("udemaeRate") val udemaeRate: Int,
    @SerialName("courseRank") val courseRank: UInt,
    @SerialName("classRank") val classRank: UInt,
    @SerialName("classValue") val classValue: Int,
    @SerialName("playDatetime") val playDatetime: String,
    @SerialName("shopId") val shopId: UInt,
    @SerialName("regionCode") val regionCode: Int,
    @SerialName("typeId") val typeId: MusicDifficultyID,
    @SerialName("musicId") val musicId: Int,
    @SerialName("difficulty") val difficulty: Int,
    @SerialName("version") val version: Int,
    @SerialName("resultBitList") val resultBitList: ByteArray,
    @SerialName("resultNum") val resultNum: Int,
    @SerialName("achievement") val achievement: Int
)
