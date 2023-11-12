package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserCharacterResponseVO(
    @SerialName("userId") val userId: ULong?,
    @SerialName("userCharacterList") val userCharacterList: Array<UserCharacter>?,
) : VOSerializer()
