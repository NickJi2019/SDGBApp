package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FavoriteKind {
    @SerialName("1")
    Icon,
    @SerialName("2")
    Plate,
    @SerialName("3")
    Title,
    @SerialName("4")
    Chara,
    @SerialName("5")
    Frame
}
