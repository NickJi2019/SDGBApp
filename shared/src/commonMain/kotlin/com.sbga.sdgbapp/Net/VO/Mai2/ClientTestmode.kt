package com.sbga.sdgbapp.Net.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientTestmode(
    @SerialName("placeId") val placeId: Int,
    @SerialName("clientId") val clientId: String,
    @SerialName("trackSingle") val trackSingle: Int,
    @SerialName("trackMulti") val trackMulti: Int,
    @SerialName("trackEvent") val trackEvent: Int,
    @SerialName("totalMachine") val totalMachine: Int,
    @SerialName("satelliteId") val satelliteId: Int,
    @SerialName("cameraPosition") val cameraPosition: Int
)
