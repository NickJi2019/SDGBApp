package com.sbga.sdgbapp

object ConfigManager {


    object ServerURL{
        val maiApiURL = "https://maimai-gm.wahlap.com:42081/Maimai2Servlet/"
        val wechatAimeURL = "http://ai.sys-all.cn/wc_aime/api/get_data"
    }
    val version = "1.33"

    val placeId = 1641
    val regionId = 1
    val isEventMode = false
    val isFreePlay = false

    val keyChipId = "A63E-01C30466404"
    val keyChipIdShortValue = "A63E01D8972"

    object SecureManager {
        object AES{
            val key: String = "7D:Q4M:3TW<p7iCwIryEUlo3RF5>O22["
            val iv: String = "NZuqK9:CX0Lnht2E"
        }
        object obfuscate{
            val obfuscateParam: String = "B6c4dAC4"
        }
        object WechatAime {
            val salt = "XcW5FW4cPArBXEk4vzKz3CIrMuA5EVVW"
        }
    }
}