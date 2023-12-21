package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MapEncountNpc(
    @SerialName("npcId") val npcId: Int,
    @SerialName("musicId") val musicId: Int
)
