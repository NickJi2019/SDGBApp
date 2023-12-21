package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserActivity(
    @SerialName("playList") val playList: Array<UserAct>,
    @SerialName("musicList") val musicList: Array<UserAct>
)
