package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserExtendResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("userExtend") val userExtend: UserExtend?,
) : VOSerializer()
