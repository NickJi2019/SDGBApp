package com.sbga.sdgbapp.Utility

expect object Compressor {
    fun deflate(data: ByteArray): ByteArray
    fun inflate(data: ByteArray): ByteArray
}