package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserDetailResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("userData") val userData: UserDetail?,
    @SerialName("banState") val banState: Int?,
) : VOSerializer()
