package com.sbga.sdgbapp.Utility


import kotlinx.cinterop.*
import kotlinx.coroutines.*
import platform.Foundation.*
import platform.zlib.*

actual object Compressor {
    @OptIn(ExperimentalForeignApi::class)
    actual fun deflate(data: ByteArray): ByteArray {
        memScoped {
            val stream = z_stream
            sizeOf<z_stream>()
        }
        TODO()
    }

    actual fun inflate(data: ByteArray): ByteArray {
        TODO("Not yet implemented")
    }
}