package com.sbga.sdgbapp.Utility

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object JsonUtil {
    inline fun <reified T> toJsonString(t: T): String {
        return Json.encodeToString<T>(t)
    }

    inline fun <reified T> String.toClass(): T {
        return Json.decodeFromString(this)
    }
}