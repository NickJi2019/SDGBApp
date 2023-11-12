package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserAllRequestVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("playlogId") val playlogId: ULong,
    @SerialName("isEventMode") val isEventMode: Boolean,
    @SerialName("isFreePlay") val isFreePlay: Boolean,
    @SerialName("upsertUserAll") val upsertUserAll: UserAll
) : VOSerializer()
