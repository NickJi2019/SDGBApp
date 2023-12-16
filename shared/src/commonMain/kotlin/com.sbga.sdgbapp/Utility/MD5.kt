package com.sbga.sdgbapp.Utility

expect object MD5 {
    fun md5(string: String): ByteArray
}

object MD5Extension {
    fun String.md5(): ByteArray = MD5.md5(this)
}