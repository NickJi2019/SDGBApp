package com.sbga.sdgbapp.Utility

expect object Compressor {
    fun deflate(data: ByteArray): ByteArray
    fun inflate(data: ByteArray): ByteArray
}

object CompressorExtension {
    fun ByteArray.deflate(): ByteArray = Compressor.deflate(this)
    fun ByteArray.inflate(): ByteArray = Compressor.inflate(this)
}