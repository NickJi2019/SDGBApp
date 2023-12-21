package com.sbga.sdgbapp.Net.VO.Mai2

import com.sbga.sdgbapp.Net.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UpsertResponseVO(
    @SerialName("returnCode") val returnCode: Int = 0,
    @SerialName("apiName") val apiName: String = ""
) : VOSerializer()