package com.sbga.sdgbapp.Aime

import com.sbga.sdgbapp.ConfigManager
import com.sbga.sdgbapp.Utility.DateTime
import com.sbga.sdgbapp.Utility.Extensions.deserialize
import com.sbga.sdgbapp.Utility.Extensions.serialize
import com.sbga.sdgbapp.Utility.Extensions.sha256
import com.sbga.sdgbapp.Utility.NetHttpClient

object WechatAime :IAime {
    override fun getUserId(input: String /*qr code*/): WechatAimeGetUserIdResponseVO{
        NetHttpClient(ConfigManager.wechatAimeURL).run {
            val time = DateTime.getTokyoDateTime()
            request(
                mapOf("Contention" to "Keep-Alive", "Host" to "ai.sys-all.cn", "User-Agent" to "WC_AIME_LIB"),
                body =  WechatAimeGetUserIdRequestVO(
                    chipID = ConfigManager.keyChipId,
                    openGameID = "MAID",
                    key = "${ConfigManager.keyChipId}$time${ConfigManager.SecureManager.WechatAime.salt}".sha256().uppercase(),
                    qrCode = if(input.length > 64) input.substring(0, 64) else input,
                    timestamp = time
                ).serialize().encodeToByteArray(),
                method = "POST"
            )
            println(getResponse().decodeToString())
            val res = getResponse().deserialize<WechatAimeGetUserIdResponseVO>()
            finalize()
            return res
            //-1: 二维码过期，-50:请求不合格
        }
    }
}