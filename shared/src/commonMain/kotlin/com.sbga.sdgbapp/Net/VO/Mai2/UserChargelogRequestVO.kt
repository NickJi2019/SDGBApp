package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserChargelogRequestVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("userChargelog") val userChargelog: UserChargelog,
    @SerialName("userCharge") val userCharge: UserCharge
) : VOSerializer()
