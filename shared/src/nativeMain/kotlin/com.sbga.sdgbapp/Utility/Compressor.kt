package com.sbga.sdgbapp.Utility


import kotlinx.cinterop.*
import kotlinx.coroutines.*
import platform.Foundation.*
import platform.Foundation.NSData
import platform.Foundation.create
import platform.posix.*
import platform.zlib.*


@OptIn(BetaInteropApi::class)
actual object Compressor {
    @OptIn(ExperimentalForeignApi::class)
    fun NSData.toByteArray(): ByteArray = ByteArray(this@toByteArray.length.toInt()).apply {
        usePinned {
            memcpy(it.addressOf(0), this@toByteArray.bytes, this@toByteArray.length)
        }
    }
    @OptIn(ExperimentalForeignApi::class)
    fun ByteArray.toNSData(): NSData? = memScoped{
        val string = NSString.create(string = this@toNSData.decodeToString())
        return string.dataUsingEncoding(NSUTF8StringEncoding)
    }


    @OptIn(ExperimentalForeignApi::class)
    actual fun deflate(data: ByteArray): ByteArray {
        memScoped {
//            val size = data.size
//            println(1)
//            val bufferSize = compressBound(data.size.convert())
//            println(2)
//            val bufferSizeRef = calloc(1u, sizeOf<uLongfVar>().convert())
//            println(3)
//            val buffer = malloc(bufferSize)
//            println(4)
//            val dataRef = (malloc(size.convert()) as CPointer<uLongfVar>).apply {
//                println(5)
//                for (i in data.indices){
//
//                    this[i] = data[i].convert()
//                }
//                println(6)
//            }
//            println(7)
            // 计算压缩后的最大可能大小
            val maxCompressedSize = compressBound(data.size.convert())

            // 分配内存用于存储压缩后的数据
            val outputBuffer = ByteArray(maxCompressedSize.toInt())

            // 转换输入数据为指针
            val inputBuffer = data.asUByteArray().toCValues()

            // 设置压缩参数
            val compressedSize = alloc<uLongVar>()

            val a= malloc(maxCompressedSize) as CPointer<uBytefVar>
            compress(a, compressedSize.ptr, inputBuffer, data.size.toULong())
            return a.readBytes(maxCompressedSize.toInt())
        }
    }

    actual fun inflate(data: ByteArray): ByteArray {
        TODO("Not yet implemented")
    }
}