package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserPreviewRequestVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("segaIdAuthKey") val segaIdAuthKey: String
) : VOSerializer()