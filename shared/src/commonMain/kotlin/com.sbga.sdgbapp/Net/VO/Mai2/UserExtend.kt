package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.DB.SortMusicID
import com.sbga.sdgbapp.DB.SortTabID
import com.sbga.sdgbapp.Manager.PlaystatusTabID
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserExtend(
    @SerialName("selectMusicId") val selectMusicId: Int,
    @SerialName("selectDifficultyId") val selectDifficultyId: Int,
    @SerialName("categoryIndex") val categoryIndex: Int,
    @SerialName("musicIndex") val musicIndex: Int,
    @SerialName("extraFlag") val extraFlag: Int,
    @SerialName("selectScoreType") val selectScoreType: Int,
    @SerialName("extendContentBit") val extendContentBit: ULong,
    @SerialName("isPhotoAgree") val isPhotoAgree: Boolean,
    @SerialName("isGotoCodeRead") val isGotoCodeRead: Boolean,
    @SerialName("selectResultDetails") val selectResultDetails: Boolean,
    @SerialName("sortCategorySetting") val sortCategorySetting: SortTabID,
    @SerialName("sortMusicSetting") val sortMusicSetting: SortMusicID,
    @SerialName("playStatusSetting") val playStatusSetting: PlaystatusTabID,
    @SerialName("selectedCardList") val selectedCardList: IntArray,
    @SerialName("encountMapNpcList") val encountMapNpcList: Array<MapEncountNpc>
)
