package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ItemKind {
    @SerialName("1")
    Plate,
    @SerialName("2")
    Title,
    @SerialName("3")
    Icon,
    @SerialName("4")
    Present,
    @SerialName("5")
    Music,
    @SerialName("6")
    MusicMas,
    @SerialName("7")
    MusicRem,
    @SerialName("8")
    MusicSrg,
    @SerialName("9")
    Character,
    @SerialName("10")
    Partner,
    @SerialName("11")
    Frame,
    @SerialName("12")
    Ticket;
}
