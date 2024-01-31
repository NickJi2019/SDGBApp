package com.sbga.sdgbapp.Net.Packet

import com.sbga.sdgbapp.ConfigManager
import com.sbga.sdgbapp.Net.VO.Mai2.*
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Utility.DateTime


object Packet{
    private val e:Exception = Exception("No response")
    fun getGameCharge():GameChargeResponseVO{
        return NetIO.sendRequest(
            NetQuery<GameChargeRequestVO,GameChargeResponseVO>("GetGameChargeApi",0uL).apply {
                request = GameChargeRequestVO(isAll = false)
            }
        ).response?:throw e
    }

    fun getGameEvent():GameEventResponseVO{
        return NetIO.sendRequest(
            NetQuery<GameEventRequestVO,GameEventResponseVO>("GetGameEventApi",0uL).apply {
                request = GameEventRequestVO(type = 1, isAllEvent = true)
            }
        ).response?:throw e
    }

    fun getGameNgMusicId():GameNgMusicIdResponseVO{
        return NetIO.sendRequest(
            NetQuery<GameNgMusicIdRequestVO,GameNgMusicIdResponseVO>("GetGameNgMusicIdApi",0uL).apply {
                request = GameNgMusicIdRequestVO()
            }
        ).response?:throw e
    }

    fun getGameWordNgList(){

    }

    fun getGameRanking():GameRankingResponseVO{
        return NetIO.sendRequest(
            NetQuery<GameRankingRequestVO,GameRankingResponseVO>("GetGameRankingApi",0uL).apply {
                request = GameRankingRequestVO()
            }
        ).response?:throw e
    }
    fun getGameSetting():GameSettingResponseVO{
        return NetIO.sendRequest(
            NetQuery<GameSettingRequestVO,GameSettingResponseVO>("GetGameSettingApi",0uL).apply {
                request = GameSettingRequestVO(placeId = ConfigManager.placeId, clientId = ConfigManager.keyChipIdShortValue)
            }
        ).response?:throw e
    }

    fun getGameTournamentInfo():GameTournamentInfoResponseVO{
        return NetIO.sendRequest(
            NetQuery<GameTournamentInfoRequestVO,GameTournamentInfoResponseVO>("GetGameTournamentInfoApi",0uL).apply {
                request = GameTournamentInfoRequestVO()
            }
        ).response?:throw e
    }

    fun getTransferFriend(userId:ULong):TransferFriendResponseVO{
        return NetIO.sendRequest(
            NetQuery<TransferFriendRequestVO,TransferFriendResponseVO>("GetTransferFriendApi",userId).apply {
                request = TransferFriendRequestVO(userId)
            }
        ).response?:throw e
    }
    fun getUserActivity(userId: ULong):UserActivityResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserActivityRequestVO,UserActivityResponseVO>("GetUserActivityApi",userId).apply {
                request = UserActivityRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserCard(userId: ULong):UserCardResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserCardRequestVO,UserCardResponseVO>("GetUserCardApi",userId).apply {
                request = UserCardRequestVO(userId, 0)
            }
        ).response?:throw e
    }

    fun getUserCharacter(userId: ULong):UserCharacterResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserCharacterRequestVO,UserCharacterResponseVO>("GetUserCharacterApi",userId).apply {
                request = UserCharacterRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserCharge(userId: ULong):UserChargeResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserChargeRequestVO,UserChargeResponseVO>("GetUserChargeApi",userId).apply {
                request = UserChargeRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserCourse(userId: ULong):UserCourseResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserCourseRequestVO,UserCourseResponseVO>("GetUserCourseApi",userId).apply {
                request = UserCourseRequestVO(userId, 0)
            }
        ).response?:throw e
    }

    fun getUserData(userId: ULong):UserDetailResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserDetailRequestVO,UserDetailResponseVO>("GetUserDataApi",userId).apply {
                request = UserDetailRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserExtend(userId: ULong):UserExtendResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserExtendRequestVO,UserExtendResponseVO>("GetUserExtendApi",userId).apply {
                request = UserExtendRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserFavorite(userId: ULong, kind:Int):UserFavoriteResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserFavoriteRequestVO,UserFavoriteResponseVO>("GetUserFavoriteApi",userId).apply {
                request = UserFavoriteRequestVO(userId, kind)
            }
        ).response?:throw e
    }

    fun getUserFriendSeasonRanking(userId: ULong):UserFriendSeasonRankingResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserFriendSeasonRankingRequestVO,UserFriendSeasonRankingResponseVO>("GetUserFriendSeasonRankingApi",userId).apply {
                request = UserFriendSeasonRankingRequestVO(userId,0)
            }
        ).response?:throw e
    }

    fun getUserGhost(userId: ULong):UserGhostResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserGhostRequestVO,UserGhostResponseVO>("GetUserGhostApi",userId).apply {
                request = UserGhostRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserItem(userId: ULong, itemId:Long):UserItemResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserItemRequestVO,UserItemResponseVO>("GetUserItemApi",userId).apply {
                request = UserItemRequestVO(userId, itemId)
            }
        ).response?:throw e
    }

    fun getUserLoginBonus(userId: ULong):UserLoginBonusResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserLoginBonusRequestVO,UserLoginBonusResponseVO>("GetUserLoginBonusApi",userId).apply {
                request = UserLoginBonusRequestVO(userId, 0)
            }
        ).response?:throw e
    }

    fun getUserMap(userId: ULong):UserMapResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserMapRequestVO,UserMapResponseVO>("GetUserMapApi",userId).apply {
                request = UserMapRequestVO(userId,0)
            }
        ).response?:throw e
    }

    fun getUserMusic(userId: ULong):UserMusicResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserMusicRequestVO,UserMusicResponseVO>("GetUserMusicApi",userId).apply {
                request = UserMusicRequestVO(userId,0)
            }
        ).response?:throw e
    }

    fun getUserOption(userId: ULong):UserOptionResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserOptionRequestVO,UserOptionResponseVO>("GetUserOptionApi",userId).apply {
                request = UserOptionRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserPortrait(userId: ULong):GetUserPortraitResponseVO{
        return NetIO.sendRequest(
            NetQuery<GetUserPortraitRequestVO,GetUserPortraitResponseVO>("GetUserPortraitApi",userId).apply {
                request = GetUserPortraitRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserPreview(userId: ULong):UserPreviewResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserPreviewRequestVO,UserPreviewResponseVO>("GetUserPreviewApi",userId).apply {
                request = UserPreviewRequestVO(userId, "")
            }
        ).response?:throw e
    }

    fun getUserRating(userId: ULong):UserRatingResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserRatingRequestVO,UserRatingResponseVO>("GetUserRatingApi",userId).apply {
                request = UserRatingRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserRecommendRateMusic(userId: ULong):UserRecommendRateMusicResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserRecommendRateMusicRequestVO,UserRecommendRateMusicResponseVO>("GetUserRecommendRateMusicApi",userId).apply {
                request = UserRecommendRateMusicRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserRecommendSelectionMusic(userId: ULong):UserRecommendSelectionMusicResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserRecommendSelectionMusicRequestVO,UserRecommendSelectionMusicResponseVO>("GetUserRecommendSelectionMusicApi",userId).apply {
                request = UserRecommendSelectionMusicRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserRegion(userId: ULong):UserRegionResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserRegionRequestVO,UserRegionResponseVO>("GetUserRegionApi",userId).apply {
                request = UserRegionRequestVO(userId)
            }
        ).response?:throw e
    }

    fun getUserScoreRanking(userId: ULong):UserScoreRankingResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserScoreRankingRequestVO,UserScoreRankingResponseVO>("GetUserScoreRankingApi",userId).apply {
                request = UserScoreRankingRequestVO(userId, 0)
            }
        ).response?:throw e
    }

    fun ping():PingResponseVO{
        return NetIO.sendRequest(
            NetQuery<PingRequestVO,PingResponseVO>("Ping", 0uL).apply {
                request = PingRequestVO()
            }
        ).response?:throw e
    }

    fun uploadUserChargelog(userId: ULong, src:UserCharge, srcLog:UserChargelog):UpsertResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserChargelogRequestVO,UpsertResponseVO>("UploadUserChargelogApi", 0uL).apply {
                request = UserChargelogRequestVO(userId, srcLog, src)
            }
        ).response?:throw e
    }

    fun uploadUserPhoto(index:Int, userId:ULong, trackNo:Int, source:ByteArray,):UpsertResponseVO{
        TODO()
        return NetIO.sendRequest(
            NetQuery<UserPhotoRequestVO,UpsertResponseVO>("UploadUserPhotoApi", 0uL).apply {
                TODO()
            }
        ).response?:throw e
    }

    fun uploadUserPlaylog(userId: ULong, srcLog:UserPlaylog):UpsertResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserPlaylogRequestVO,UpsertResponseVO>("UploadUserPlaylogApi", 0uL).apply {
                request = UserPlaylogRequestVO(userId, srcLog)
            }
        ).response?:throw e
    }

    fun uploadUserPortrait(src:UserPortrait):UpsertResponseVO{
        TODO()
        return NetIO.sendRequest(
            NetQuery<UploadUserPortraitRequestVO,UpsertResponseVO>("UploadUserPortraitApi", 0uL).apply {
                TODO()
            }
        ).response?:throw e
    }

    fun upsertClientBookkeeping(src:ClientBookkeeping):UpsertResponseVO{
        TODO()
        return NetIO.sendRequest(
            NetQuery<ClientBookkeepingRequestVO,UpsertResponseVO>("UpsertClientBookkeepingApi", 0uL).apply {
                request = ClientBookkeepingRequestVO(src)
            }
        ).response?:throw e
    }

    fun upsertClientSetting():UpsertResponseVO{
        TODO()
        return NetIO.sendRequest(
            NetQuery<ClientSettingRequestVO,UpsertResponseVO>("UpsertClientSettingApi", 0uL).apply {
                TODO("request = ClientSettingRequestVO()")
            }
        ).response?:throw e
    }

    fun upsertClientTestmode():UpsertResponseVO{
        TODO()
        return NetIO.sendRequest(
            NetQuery<ClientTestmodeRequestVO,UpsertResponseVO>("UpsertClientTestmodeApi", 0uL).apply {
                TODO()
            }
        ).response?:throw e
    }

    fun upsertClientUpload(errorLog:String, source: ByteArray): UpsertResponseVO {
        TODO()
        return NetIO.sendRequest(
            NetQuery<ClientUploadRequestVO,UpsertResponseVO>("UpsertClientUploadApi", 0uL).apply {
                TODO()
            }
        ).response?:throw e
    }

    fun upsertUserAll(index:Int, userId:ULong, src:UserAll, loginVO:UserLoginResponseVO):UpsertResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserAllRequestVO,UpsertResponseVO>("UpsertUserAllApi", userId).apply {
                request = UserAllRequestVO(userId, loginVO.loginId?:0uL, ConfigManager.isEventMode, ConfigManager.isFreePlay, src)
            }
        ).response?:throw e
    }

    fun userLogin(userId: ULong, accessCode:String, isContinue:Boolean, genericFlag:Int):UserLoginResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserLoginRequestVO,UserLoginResponseVO>("UserLoginApi", userId).apply {
                request = UserLoginRequestVO(
                    userId = userId,
                    accessCode = accessCode,
                    isContinue = isContinue,
                    genericFlag = genericFlag,
                    placeId = ConfigManager.placeId,
                    regionId = ConfigManager.regionId,
                    clientId = ConfigManager.keyChipIdShortValue,
                    dateTime = DateTime.getTimeStamp().toString()
                )
            }
        ).response?:throw e
    }

    fun userLogout(userId: ULong):UserLogoutResponseVO{
        return NetIO.sendRequest(
            NetQuery<UserLogoutRequestVO,UserLogoutResponseVO>("UserLogoutApi", userId).apply {
                request = UserLogoutRequestVO(userId)
            }
        ).response?:throw e
    }
}