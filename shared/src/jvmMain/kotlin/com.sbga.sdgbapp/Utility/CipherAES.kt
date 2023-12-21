package com.sbga.sdgbapp.Utility

import com.sbga.sdgbapp.ConfigManager
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


actual object CipherAES {
    private val encrypter = Cipher.getInstance("AES/CBC/PKCS5Padding").apply {
        init(Cipher.ENCRYPT_MODE, SecretKeySpec(ConfigManager.SecureManager.AES.key.toByteArray(), "AES"), IvParameterSpec(
            ConfigManager.SecureManager.AES.iv.toByteArray()))
    }
    private val decrypter = Cipher.getInstance("AES/CBC/PKCS5Padding").apply {
        init(Cipher.DECRYPT_MODE, SecretKeySpec(ConfigManager.SecureManager.AES.key.toByteArray(), "AES"), IvParameterSpec(
            ConfigManager.SecureManager.AES.iv.toByteArray()))
    }
    actual fun encrypt(data:String): String {
        return encrypt(data.toByteArray()).decodeToString()
    }

    actual fun encrypt(data:ByteArray): ByteArray {
        return encrypter.doFinal(data)
    }

    actual fun decrypt(data: String): String {
        return decrypt(data.toByteArray()).decodeToString()
    }

    actual fun decrypt(data: ByteArray): ByteArray {
        return decrypter.doFinal(data)
    }

}