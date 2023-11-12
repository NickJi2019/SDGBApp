package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserItemRequestVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("nextIndex") val nextIndex: Long,
    @SerialName("maxCount") val maxCount: Int = 100
) : VOSerializer()