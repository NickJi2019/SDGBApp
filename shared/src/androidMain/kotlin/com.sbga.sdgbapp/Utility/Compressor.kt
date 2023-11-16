package com.sbga.sdgbapp.Utility

import java.util.zip.*

actual object Compressor {


    actual fun deflate(data: ByteArray): ByteArray {
        val compressor = Deflater()
        compressor.reset()
        compressor.setInput(data)
        compressor.finish()
        val output = ByteArray(data.size)
        val compressedDataLength = compressor.deflate(output)
        compressor.end()
        return output.copyOf(compressedDataLength)
    }

    actual fun inflate(data: ByteArray): ByteArray {
        val compressor = Inflater()
        compressor.reset()
        compressor.setInput(data)
        val output = ByteArray(data.size)
        val compressedDataLength = compressor.inflate(output)
        compressor.end()
        return output.copyOf(compressedDataLength)
    }
}