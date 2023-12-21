package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameEventRequestVO(
    @SerialName("type") val type: Int,
    @SerialName("isAllEvent") val isAllEvent: Boolean
) : VOSerializer()
