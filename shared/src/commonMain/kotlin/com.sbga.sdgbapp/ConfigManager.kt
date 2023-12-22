package com.sbga.sdgbapp

object ConfigManager {
    val maiApiURL = "https://maimai-gm.wahlap.com:42081/Maimai2Servlet/"
    val wechatAimeURL = "http://ai.sys-all.cn/wc_aime/api/get_data"

    val clientId: String = "A63E01D8972"
    val placeId = 1641
    val regionId = 1
    val isEventMode = false
    val isFreePlay = false

    val keyChipId = "A63E-01C30466404"



    object SecureManager {
        object AES{

            val key: String = "F2Rc8F0x2Ly6LiIFy9K>s_Y0Bum62H;R"
            val iv: String = "PR12H;E2Brw@5kJ<"
        }
        object obfuscate{
            val obfuscateParam: String = "SX2bTFe8"
        }
        object WechatAime {
            val salt = "XcW5FW4cPArBXEk4vzKz3CIrMuA5EVVW"
        }
    }
}