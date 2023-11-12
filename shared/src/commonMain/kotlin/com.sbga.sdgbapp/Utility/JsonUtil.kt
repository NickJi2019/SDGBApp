package com.sbga.sdgbapp.Utility

import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement

object JsonUtil {
    fun VOSerializer.toJsonString(): String {
        return Json.encodeToString(this)
    }

    inline fun <reified T> String.toClass(): T {
        return Json.decodeFromString(this)
    }
}