package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GameNgMusicIdResponseVO(
    @SerialName("length") var length: Long?,
    @SerialName("musicIdList") var musicIdList: IntArray?,
) : VOSerializer()

