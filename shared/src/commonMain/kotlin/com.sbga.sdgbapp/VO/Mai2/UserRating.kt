package com.sbga.sdgbapp.VO.Mai2

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRating(
    @SerialName("rating") val rating: Int,
    @SerialName("ratingList") val ratingList: Array<UserRate>,
    @SerialName("newRatingList") val newRatingList: Array<UserRate>,
    @SerialName("nextRatingList") val nextRatingList: Array<UserRate>,
    @SerialName("nextNewRatingList") val nextNewRatingList: Array<UserRate>,
    @SerialName("udemae") val udemae: UserUdemae
)
