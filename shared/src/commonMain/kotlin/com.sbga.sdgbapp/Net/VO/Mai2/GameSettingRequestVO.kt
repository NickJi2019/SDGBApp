package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameSettingRequestVO(
    @SerialName("placeId") val placeId: Int,
    @SerialName("clientId") val clientId: String
) : VOSerializer()
