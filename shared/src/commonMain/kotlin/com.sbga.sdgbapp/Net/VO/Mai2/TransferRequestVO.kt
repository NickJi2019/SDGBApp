package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TransferRequestVO(
    @SerialName("userId") val userId: ULong,
    @SerialName("userData") val userData: Array<UserDetail>,
    @SerialName("userMusicDetailList") val userMusicDetailList: Array<UserMusicDetail>,
    @SerialName("isNewMusicDetailList") val isNewMusicDetailList: String
) : VOSerializer()
