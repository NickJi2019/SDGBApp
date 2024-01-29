package com.sbga.sdgbapp.Utility


import com.sbga.sdgbapp.ConfigManager
import kotlinx.cinterop.*
import platform.CoreCrypto.*
import platform.posix.size_t
import platform.posix.size_tVar

@OptIn(ExperimentalForeignApi::class)

actual object CipherAES {
    private fun crypt(data: ByteArray, operation:CCOperation):ByteArray{
        memScoped {
            val outputLength = alloc<size_tVar>()
            outputLength.value = when (operation) {
                    kCCEncrypt -> {
                        ((data.size + 15) / 16 * 16).convert<size_t>()
                    }
                    kCCDecrypt -> {
                        data.size.convert<size_t>()
                    }
                    else -> {
                        throw Exception("operation error")
                    }
                }

            val outputData:CValuesRef<*> = allocArray<ByteVar>(outputLength.value.toInt())

            CCCrypt(
                operation,
                kCCAlgorithmAES,
                kCCOptionPKCS7Padding,
                ConfigManager.SecureManager.AES.key.encodeToByteArray().toCValues(),
                kCCKeySizeAES256.convert(),
                ConfigManager.SecureManager.AES.iv.encodeToByteArray().toCValues(),
                data.toCValues(),
                data.size.convert(),
                outputData,
                outputLength.value.convert(),
                outputLength.ptr
            ).let {
                if (it != kCCSuccess) {
                    log.error("crypt error")
                    log.error(outputData.getPointer(this).readBytes(outputLength.value.toInt()))
                    throw Exception("crypt error")
                }
            }
            return outputData.getPointer(this).readBytes(outputLength.value.toInt())
        }
    }

    actual fun encrypt(data:ByteArray): ByteArray {
        return crypt(data, kCCEncrypt)
    }

    actual fun decrypt(data: ByteArray): ByteArray {
        return crypt(data, kCCDecrypt)
    }

}
