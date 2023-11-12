package com.sbga.sdgbapp.VO.Mai2


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserAll(
    @SerialName("userData") val userData: Array<UserDetail>,
    @SerialName("userExtend") val userExtend: Array<UserExtend>,
    @SerialName("userOption") val userOption: Array<UserOption>,
    @SerialName("userCharacterList") val userCharacterList: Array<UserCharacter>,
    @SerialName("userGhost") val userGhost: Array<UserGhost>,
    @SerialName("userMapList") val userMapList: Array<UserMap>,
    @SerialName("userLoginBonusList") val userLoginBonusList: Array<UserLoginBonus>,
    @SerialName("userRatingList") val userRatingList: Array<UserRating>,
    @SerialName("userItemList") val userItemList: Array<UserItem>,
    @SerialName("userMusicDetailList") val userMusicDetailList: Array<UserMusicDetail>,
    @SerialName("userCourseList") val userCourseList: Array<UserCourse>,
    @SerialName("userFriendSeasonRankingList") val userFriendSeasonRankingList: Array<UserFriendSeasonRanking>,
    @SerialName("userChargeList") val userChargeList: Array<UserCharge>,
    @SerialName("userFavoriteList") val userFavoriteList: Array<UserFavorite>,
    @SerialName("userActivityList") val userActivityList: Array<UserActivity>,
    @SerialName("userGamePlaylogList") val userGamePlaylogList: Array<UserGamePlaylog>,
    @SerialName("isNewCharacterList") val isNewCharacterList: String,
    @SerialName("isNewMapList") val isNewMapList: String,
    @SerialName("isNewLoginBonusList") val isNewLoginBonusList: String,
    @SerialName("isNewItemList") val isNewItemList: String,
    @SerialName("isNewMusicDetailList") val isNewMusicDetailList: String,
    @SerialName("isNewCourseList") val isNewCourseList: String,
    @SerialName("isNewFavoriteList") val isNewFavoriteList: String,
    @SerialName("isNewFriendSeasonRankingList") val isNewFriendSeasonRankingList: String
)
