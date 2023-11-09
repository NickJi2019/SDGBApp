package com.sbga.sdgbapp.Utility


val BLOCK_SIZE: Int = 128
val KEY_SIZE: Int = 256
val AesKey: String = "F2Rc8F0x2Ly6LiIFy9K>s_Y0Bum62H;R"
val AesIV: String = "PR12H;E2Brw@5kJ<"

expect object CipherAES {
    fun encrypt(data: String):String
    fun decrypt(data: String):String
    fun encrypt(data: ByteArray):ByteArray
    fun decrypt(data: ByteArray):ByteArray
}