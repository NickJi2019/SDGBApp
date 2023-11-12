package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameEventResponseVO(
    @SerialName("type") val type: Int?,
    @SerialName("gameEventList") val gameEventList: Array<GameEvent>?,
) : VOSerializer()
