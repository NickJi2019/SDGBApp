package com.sbga.sdgbapp.Utility

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object JsonUtil {
    inline fun <reified T> serialize(t: T): String {
        return Json.encodeToString<T>(t)
    }
    inline fun <reified T> deserialize(string: String): T {
        return Json.decodeFromString(string)
    }
}