package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserGhostResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("userGhostList") val userGhostList: Array<UserGhost>?,
) : VOSerializer()
