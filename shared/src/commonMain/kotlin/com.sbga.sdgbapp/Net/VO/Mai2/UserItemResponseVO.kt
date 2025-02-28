package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserItemResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("nextIndex") val nextIndex: Long?,
    @SerialName("itemKind") val itemKind: Int?,
    @SerialName("userItemList") val userItemList: Array<UserItem>?,
) : VOSerializer()
