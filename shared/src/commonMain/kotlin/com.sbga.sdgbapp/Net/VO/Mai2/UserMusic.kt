package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserMusic(
    @SerialName("userMusicDetailList") val userMusicDetailList: Array<UserMusicDetail>
)