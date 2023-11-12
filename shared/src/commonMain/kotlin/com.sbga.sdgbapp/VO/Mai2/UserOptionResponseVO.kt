package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserOptionResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("userOption") val userOption: UserOption?,
) : VOSerializer()