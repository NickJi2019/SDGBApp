package com.sbga.sdgbapp.Utility

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object JsonUtil {
    val json = Json {
        ignoreUnknownKeys = true
    }

    inline fun <reified T> serialize(t: T): String {
        return json.encodeToString<T>(t)
    }
    inline fun <reified T> deserialize(string: String): T {
        return json.decodeFromString(string)
    }
}