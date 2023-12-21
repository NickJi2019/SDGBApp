package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserLoginResponseVO(
    @SerialName("returnCode") val returnCode: Int?,
    @SerialName("lastLoginDate") val lastLoginDate: String?,
    @SerialName("loginCount") val loginCount: Int?,
    @SerialName("consecutiveLoginCount") val consecutiveLoginCount: Int?,
    @SerialName("loginId") val loginId: ULong?,
) : VOSerializer()
