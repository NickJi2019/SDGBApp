package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserRecommendRateMusicRequestVO(
    @SerialName("userId") val userId: ULong
) : VOSerializer()
