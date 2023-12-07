package com.sbga.sdgbapp.Utility


import kotlinx.cinterop.*
import platform.posix.*
import platform.zlib.*

@OptIn(ExperimentalForeignApi::class)

actual object Compressor {
    val log = Log()
    actual fun deflate(data: ByteArray): ByteArray {
        memScoped{
            val outputLength = alloc<uLongfVar>().apply {
                value = compressBound(data.size.convert())
            }
            val outputData = allocArray<uBytefVar>(outputLength.value.toInt())
            val inputData = data.toUByteArray().toCValues()

            compress(outputData, outputLength.ptr, inputData, data.size.convert()).let {
                if (it == Z_OK) {
                    log.info("deflate success")
                } else {
                    log.error("deflate error")
                    throw Exception("deflate error")
                }
            }
            return outputData.getPointer(this).readBytes(outputLength.value.toInt()+1)
        }
    }

    actual fun inflate(data: ByteArray): ByteArray {
        memScoped {
            val outputLength = alloc<uLongfVar>().apply {
                value = compressBound(data.size.convert()) * 2u
            }
            var outputData = allocArray<uBytefVar>(outputLength.value.toInt())
            val inputData = data.toUByteArray().toCValues()
            var flag: Int
            while(uncompress(outputData, outputLength.ptr, inputData, data.size.convert()).also { flag = it } == Z_BUF_ERROR){
                outputLength.value *= 2u

                val newOutputData = allocArray<uBytefVar>((outputLength.value * 2u).toInt())
                memcpy(newOutputData, outputData, outputLength.value.convert())
                free(outputData)
                outputData = newOutputData
            }

            if (flag == Z_OK) {
                log.info("inflate success")
            } else {
                log.error("inflate error")
                throw Exception("inflate error")
            }

            return outputData.getPointer(this).readBytes(outputLength.value.toInt())
        }
    }
}