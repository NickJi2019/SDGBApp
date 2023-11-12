package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.Serializable

@Serializable
class GameNgMusicIdResponseVO(
    @SerialName("length") var length: Long?,
    @SerialName("musicIdList") var musicIdList: IntArray?,
) : VOSerializer()

