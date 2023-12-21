package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameChargeRequestVO(
    @SerialName("isAll") val isAll: Boolean
) : VOSerializer()
