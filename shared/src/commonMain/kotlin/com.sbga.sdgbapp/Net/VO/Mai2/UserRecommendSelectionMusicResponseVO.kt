package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserRecommendSelectionMusicResponseVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("userRecommendSelectionMusicIdList") val userRecommendSelectionMusicIdList: IntArray
) : VOSerializer()
