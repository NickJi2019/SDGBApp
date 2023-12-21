package com.sbga.sdgbapp.Net.VO.Mai2


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserAct(
    @SerialName("kind") val kind: Int,
    @SerialName("id") val id: Int,
    @SerialName("sortNumber") val sortNumber: Long,
    @SerialName("param1") val param1: Int,
    @SerialName("param2") val param2: Int,
    @SerialName("param3") val param3: Int,
    @SerialName("param4") val param4: Int
)
