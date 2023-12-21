package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserMusicResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("nextIndex") val nextIndex: Int?,
    @SerialName("userMusicList") val userMusicList: Array<UserMusic>?,
) : VOSerializer()