package com.sbga.sdgbapp.Utility

import kotlin.experimental.inv
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
class NetHttpClient {

    constructor()
    constructor(url: String)

    private fun checkServerParameter(inData: ByteArray, compare: ByteArray): Boolean {
        inData[43] = 61
        val array: ByteArray = CipherAES.decrypt(Base64.decode(inData.decodeToString()))
        for (i in 0 until array.size) {
            array[i] = array[i].inv() //按位取反
        }
        val array2 = array.copyOfRange(array.size - 20, array.size)

        return array2.contentEquals(compare)
    }

    var timeOutInMSec: UInt = 60000u
}