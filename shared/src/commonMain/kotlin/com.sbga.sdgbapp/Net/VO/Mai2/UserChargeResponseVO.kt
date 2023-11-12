package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserChargeResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("length") val length: Long?,
    @SerialName("userChargeList") val userChargeList: Array<UserCharge>?,
) : VOSerializer()
