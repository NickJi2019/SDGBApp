package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserPreviewResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("userName") val userName: String?,
    @SerialName("isLogin") val isLogin: Boolean?,
    @SerialName("lastGameId") val lastGameId: String?,
    @SerialName("lastDataVersion") val lastDataVersion: String?,
    @SerialName("lastRomVersion") val lastRomVersion: String?,
    @SerialName("lastLoginDate") val lastLoginDate: String?,
    @SerialName("lastPlayDate") val lastPlayDate: String?,
    @SerialName("playerRating") val playerRating: Int?,
    @SerialName("nameplateId") val nameplateId: Int?,
    @SerialName("iconId") val iconId: Int?,
    @SerialName("trophyId") val trophyId: Int?,
    @SerialName("partnerId") val partnerId: Int?,
    @SerialName("frameId") val frameId: Int?,
    @SerialName("dispRate") val dispRate: Int?,
    @SerialName("totalAwake") val totalAwake: Int?,
    @SerialName("isNetMember") val isNetMember: Int?,
    @SerialName("dailyBonusDate") val dailyBonusDate: String?,
    @SerialName("headPhoneVolume") val headPhoneVolume: Int?,
    @SerialName("isInherit") val isInherit: Boolean?,
    @SerialName("banState") val banState: Int?,
) : VOSerializer() {
    fun IsNewUser(): Boolean {
        return userName.isNullOrEmpty() || lastPlayDate.isNullOrEmpty()
    }

    fun IsInheritUser(): Boolean? {
        return isInherit
    }
}
