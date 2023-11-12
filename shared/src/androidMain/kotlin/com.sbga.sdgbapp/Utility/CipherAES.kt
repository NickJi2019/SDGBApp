package com.sbga.sdgbapp.Utility

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


actual object CipherAES {


    private val encryptInstance: Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding").apply {
        init(
            Cipher.ENCRYPT_MODE,
            SecretKeySpec(AesKey.toByteArray(), "AES"),
            IvParameterSpec(AesIV.toByteArray())
        )
    }
    private val decryptInstance: Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding").apply {
        init(
            Cipher.DECRYPT_MODE,
            SecretKeySpec(AesKey.toByteArray(), "AES"),
            IvParameterSpec(AesIV.toByteArray())
        )
    }


    actual fun encrypt(data: ByteArray): ByteArray {
        return encryptInstance.doFinal(data)
    }

    actual fun decrypt(data: ByteArray): ByteArray {
        return decryptInstance.doFinal(data)
    }

    actual fun encrypt(data: String): String {
        return encrypt(data.encodeToByteArray()).decodeToString()
    }

    actual fun decrypt(data: String): String {
        return decrypt(data.encodeToByteArray()).decodeToString()
    }

}