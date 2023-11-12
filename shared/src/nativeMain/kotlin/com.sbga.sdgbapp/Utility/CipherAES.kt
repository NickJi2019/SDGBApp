package com.sbga.sdgbapp.Utility


import kotlinx.cinterop.*
import platform.CoreCrypto.*
import platform.posix.calloc
import platform.posix.free

@OptIn(ExperimentalForeignApi::class)

actual object CipherAES {
    fun crypt(data: ByteArray, operation: CCOperation): ByteArray {
        memScoped {
            val pinnedData = data.pin()
            val pinnedKey = AesKey.pin()
            val pinnedIv = AesIV.pin()

            val dataPtr = pinnedData.get().toUByteArray().toCValues()
            val keyPtr = pinnedKey.get().encodeToByteArray().toCValues()
            val ivPtr = pinnedIv.get().encodeToByteArray().toCValues()

            val digestLength = ((data.size + 15) / 16 * 16)
            val bufferData = calloc(digestLength.convert(), Byte.SIZE_BITS.convert())

            val status = CCCrypt(
                operation,
                kCCAlgorithmAES,
                kCCOptionPKCS7Padding,
                keyPtr,
                kCCKeySizeAES256.convert(),
                ivPtr,
                dataPtr,
                data.size.convert(),
                bufferData,
                kCCBlockSizeAES128.convert(),
                null
            )
            val result: ByteArray

            if (status != kCCSuccess || bufferData == null) {
                throw Exception("AES encryption failed with status $status")
            } else {
                result = bufferData.readBytes(digestLength)
            }

            free(dataPtr)
            free(keyPtr)
            free(ivPtr)
            free(bufferData)

            pinnedData.unpin()
            pinnedKey.unpin()
            pinnedIv.unpin()

            return result
        }
    }

    actual fun encrypt(data: ByteArray): ByteArray {
        return crypt(data, kCCEncrypt)
    }

    actual fun decrypt(data: ByteArray): ByteArray {
        return crypt(data, kCCDecrypt)
    }

    actual fun encrypt(data: String): String {
        return encrypt(data.encodeToByteArray()).decodeToString()
    }

    actual fun decrypt(data: String): String {
        return decrypt(data.encodeToByteArray()).decodeToString()
    }

}