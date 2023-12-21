package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameRankingRequestVO(
    @SerialName("type") var type: Long = 0
) : VOSerializer()

