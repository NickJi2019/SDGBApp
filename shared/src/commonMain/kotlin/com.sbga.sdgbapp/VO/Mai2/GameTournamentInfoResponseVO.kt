package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameTournamentInfoResponseVO(
    @SerialName("length") val length: Long?,
    @SerialName("gameTournamentInfoList") val gameTournamentInfoList: Array<GameTournamentInfo>?,
) : VOSerializer()
