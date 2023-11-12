package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameChargeResponseVO(
    @SerialName("length") val length: Long?,
    @SerialName("gameChargeList") val gameChargeList: Array<GameCharge>?,
) : VOSerializer()
