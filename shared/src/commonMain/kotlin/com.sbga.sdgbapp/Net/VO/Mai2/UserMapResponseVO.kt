package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserMapResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("nextIndex") val nextIndex: Long?,
    @SerialName("userMapList") val userMapList: Array<UserMap>?,
) : VOSerializer()
