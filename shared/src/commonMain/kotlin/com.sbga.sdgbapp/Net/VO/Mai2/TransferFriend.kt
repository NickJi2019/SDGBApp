package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TransferFriend(
    @SerialName("playUserId") val playUserId: ULong,
    @SerialName("playUserName") val playUserName: String,
    @SerialName("playDate") val playDate: String,
    @SerialName("friendPoint") val friendPoint: Int,
    @SerialName("isFavorite") val isFavorite: Boolean
)
