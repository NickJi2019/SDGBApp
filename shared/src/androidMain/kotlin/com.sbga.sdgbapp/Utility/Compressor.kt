package com.sbga.sdgbapp.Utility

import java.io.ByteArrayOutputStream
import java.util.zip.*

actual object Compressor {
    actual fun deflate(data: ByteArray): ByteArray {
        val deflater = Deflater()
        deflater.reset()
        deflater.setInput(data)
        deflater.finish()

        val buffer = ByteArray(1024)
        val output = ByteArrayOutputStream()
        var outputSize = 0

        while (!deflater.finished()) {
            val justDeflatedSize = deflater.deflate(buffer)
            if (justDeflatedSize > 0) {
                output.write(buffer, 0, justDeflatedSize)
                outputSize += justDeflatedSize
            } else if (justDeflatedSize == 0 && deflater.needsInput()) {
                // 如果没有更多数据可用，退出循环
                break
            }
        }
        deflater.end()
        return output.toByteArray()
    }


    actual fun inflate(data: ByteArray): ByteArray {
        val inflater = Inflater()
        inflater.reset()
        inflater.setInput(data)

        val output = ByteArrayOutputStream() // 初始化一个足够大的字节数组
        var outputSize = 0 // 输出字节数组的大小
        val buffer = ByteArray(1024)

        while (!inflater.finished()) {
            val justInflatedSize = inflater.inflate(buffer)
            if (justInflatedSize > 0) {
                output.write(buffer, 0, justInflatedSize)
                outputSize += justInflatedSize
            } else if (justInflatedSize == 0 && inflater.needsInput()) {
                // 如果没有更多数据可用，退出循环
                break
            }
        }
        inflater.end()
        // 返回实际大小的字节数组
        return output.toByteArray()
    }
}