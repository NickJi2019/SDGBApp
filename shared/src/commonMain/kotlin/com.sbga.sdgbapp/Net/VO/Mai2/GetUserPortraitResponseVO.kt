package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GetUserPortraitResponseVO(
    @SerialName("length") val length: Int?,
    @SerialName("userPortraitList") val userPortraitList: List<UserPortrait>?,
) : VOSerializer()
