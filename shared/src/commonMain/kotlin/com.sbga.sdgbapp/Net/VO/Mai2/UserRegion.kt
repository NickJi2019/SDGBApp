package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRegion(
    @SerialName("regionId") val regionId: Int,
    @SerialName("playCount") val playCount: Int,
    @SerialName("created") val created: String
)
