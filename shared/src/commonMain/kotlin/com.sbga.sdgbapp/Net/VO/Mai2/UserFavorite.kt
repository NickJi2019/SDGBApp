package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserFavorite(
    @SerialName("userId") val userId: ULong,
    @SerialName("itemKind") val itemKind: Int,
    @SerialName("itemIdList") val itemIdList: IntArray
)
