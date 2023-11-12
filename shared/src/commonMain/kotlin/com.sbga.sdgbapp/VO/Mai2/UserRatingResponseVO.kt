package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserRatingResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("userRating") val userRating: UserRating?,
) : VOSerializer()
