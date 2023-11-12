package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserRegionResponseVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("length") val length: ULong,
    @SerialName("userRegionList") val userRegionList: Array<UserRegion>
) : VOSerializer()
