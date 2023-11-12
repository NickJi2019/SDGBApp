package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserPlaylogRequestVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("userPlaylog") val userPlaylog: UserPlaylog
) : VOSerializer()