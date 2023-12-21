package com.sbga.sdgbapp

object ConfigManager {
    const val maiApiURL = "https://maimai-gm.wahlap.com:42081/Maimai2Servlet/"
    const val clientId: String = "A63E01D8972"
    const val placeId = 1641
    const val regionId = 1
    const val isEventMode = false
    const val isFreePlay = false

    val chipId = "A63E-01C30466404"

    object SecureManager {
        object AES{

            val key: String = "F2Rc8F0x2Ly6LiIFy9K>s_Y0Bum62H;R"
            val iv: String = "PR12H;E2Brw@5kJ<"
        }
        object obfuscate{
            val obfuscateParam: String = "SX2bTFe8"
        }
    }
}