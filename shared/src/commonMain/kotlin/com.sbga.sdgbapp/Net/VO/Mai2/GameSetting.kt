package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GameSetting(
    @SerialName("isMaintenance") val isMaintenance: Boolean,
    @SerialName("requestInterval") val requestInterval: Int,
    @SerialName("rebootStartTime") val rebootStartTime: String,
    @SerialName("rebootEndTime") val rebootEndTime: String,
    @SerialName("movieUploadLimit") val movieUploadLimit: Int,
    @SerialName("movieStatus") val movieStatus: Int,
    @SerialName("movieServerUri") val movieServerUri: String,
    @SerialName("deliverServerUri") val deliverServerUri: String,
    @SerialName("oldServerUri") val oldServerUri: String,
    @SerialName("usbDlServerUri") val usbDlServerUri: String,
    @SerialName("rebootInterval") val rebootInterval: Int
)
