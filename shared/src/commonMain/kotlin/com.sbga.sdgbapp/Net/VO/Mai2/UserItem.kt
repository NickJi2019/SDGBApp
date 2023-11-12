package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserItem(
    @SerialName("itemKind") val itemKind: Int,
    @SerialName("itemId") val itemId: Int,
    @SerialName("stock") val stock: Int,
    @SerialName("isValid") val isValid: Boolean
)
