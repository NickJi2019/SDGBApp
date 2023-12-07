package com.sbga.sdgbapp.Utility

import java.util.zip.*

actual object Compressor {
    actual fun deflate(data: ByteArray): ByteArray {
        val deflater = Deflater()
        deflater.reset()
        deflater.setInput(data)
        deflater.finish()
        val output = ByteArray(data.size)
        val compressedDataLength = deflater.deflate(output)
        deflater.end()
        return output.copyOf(compressedDataLength)
    }


    actual fun inflate(data: ByteArray): ByteArray {
        val inflater = Inflater()
        inflater.reset()
        inflater.setInput(data)

        var output = ByteArray(data.size * 2) // 初始化一个足够大的字节数组
        var outputSize = 0 // 输出字节数组的大小

        var buffer = ByteArray(1024)
        while (!inflater.finished()) {
            val justInflatedSize = inflater.inflate(buffer)
            if (justInflatedSize > 0) {
                if (outputSize + justInflatedSize > output.size) {
                    // 如果输出缓冲区不够大，扩展输出缓冲区的大小
                    val newOutput = ByteArray(output.size * 2)
                    System.arraycopy(output, 0, newOutput, 0, outputSize)
                    output = newOutput
                }
                System.arraycopy(buffer, 0, output, outputSize, justInflatedSize)
                outputSize += justInflatedSize
            } else if (justInflatedSize == 0 && inflater.needsInput()) {
                // 如果没有更多数据可用，退出循环
                break
            }
        }
        inflater.end()
        // 返回实际大小的字节数组
        return output.copyOf(outputSize)
    }
}