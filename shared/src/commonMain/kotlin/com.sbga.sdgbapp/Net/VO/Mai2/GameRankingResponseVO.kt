package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameRankingResponseVO(
    @SerialName("type") val type: Long?,
    @SerialName("gameRankingList") val gameRankingList: Array<GameRanking>?,
) : VOSerializer()