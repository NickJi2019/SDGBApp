package com.sbga.sdgbapp.Utility


import kotlinx.cinterop.*
import platform.CoreCrypto.*
import platform.posix.calloc

actual object CipherAES {
    @OptIn(ExperimentalForeignApi::class)
    actual fun encrypt(data: ByteArray): ByteArray {
        memScoped {
            val dataPtr = data.toUByteArray().toCValues()
            val keyPtr = AesKey.encodeToByteArray().toCValues()
            val ivPtr = AesIV.encodeToByteArray().toCValues()

            val digestLength = ((data.size + 15) / 16 * 16)
            val bufferData = calloc(digestLength.convert(), Byte.SIZE_BITS.convert())

            val status = CCCrypt(
                kCCEncrypt,
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
            if (status != kCCSuccess || bufferData == null) {
                throw Exception("AES encryption failed with status $status")
            } else {
                bufferData.usePinned {
                    return it.get().readBytes(digestLength.toInt())
                }
            }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun decrypt(data: ByteArray): ByteArray {
        memScoped {
            val dataPtr = data.toUByteArray().toCValues()
            val keyPtr = AesKey.encodeToByteArray().toCValues()
            val ivPtr = AesIV.encodeToByteArray().toCValues()

            val digestLength = ((data.size + 15) / 16 * 16)
            val bufferData = calloc(digestLength.convert(), Byte.SIZE_BITS.convert())

            val status = CCCrypt(
                kCCDecrypt,
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
            if (status != kCCSuccess || bufferData == null) {
                throw Exception("AES encryption failed with status $status")
            } else {
                bufferData.usePinned {
                    return it.get().readBytes(digestLength.toInt())
                }
            }
        }
    }

    actual fun encrypt(data: String): String {
        return encrypt(data.encodeToByteArray()).decodeToString()
    }

    actual fun decrypt(data: String): String {
        return decrypt(data.encodeToByteArray()).decodeToString()
    }

}
