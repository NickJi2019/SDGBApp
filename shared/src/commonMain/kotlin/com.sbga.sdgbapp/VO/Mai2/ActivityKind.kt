package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ActivityKind {
    @SerialName("1")
    Play,
    @SerialName("2")
    Music
}
