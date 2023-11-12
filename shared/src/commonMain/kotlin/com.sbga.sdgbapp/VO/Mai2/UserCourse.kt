package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserCourse(
    @SerialName("courseId") val courseId: Int,
    @SerialName("isLastClear") val isLastClear: Boolean,
    @SerialName("totalRestlife") val totalRestlife: UInt,
    @SerialName("totalAchievement") val totalAchievement: UInt,
    @SerialName("totalDeluxscore") val totalDeluxscore: UInt,
    @SerialName("playCount") val playCount: UInt,
    @SerialName("clearDate") val clearDate: String,
    @SerialName("lastPlayDate") val lastPlayDate: String,
    @SerialName("bestAchievement") val bestAchievement: UInt,
    @SerialName("bestAchievementDate") val bestAchievementDate: String,
    @SerialName("bestDeluxscore") val bestDeluxscore: UInt,
    @SerialName("bestDeluxscoreDate") val bestDeluxscoreDate: String
)
