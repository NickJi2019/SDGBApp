package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameSettingResponseVO(
    @SerialName("isAouAccession") val isAouAccession: Boolean?,
    @SerialName("gameSetting") val gameSetting: GameSetting?,
) : VOSerializer()
