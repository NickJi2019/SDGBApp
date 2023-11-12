package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserFavoriteRequestVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("itemKind") val itemKind: Int
) : VOSerializer()
