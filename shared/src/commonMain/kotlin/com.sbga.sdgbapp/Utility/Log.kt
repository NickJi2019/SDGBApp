package com.sbga.sdgbapp.Utility

import io.github.aakira.napier.Napier

class Log {
    fun verbose(vararg str: String) {
        Napier.v(str.joinToString(" "))
    }

    fun debug(vararg str: String) {
        Napier.d(str.joinToString(" "))
    }

    fun info(vararg str: String) {
        Napier.i(str.joinToString(" "))
    }

    fun warn(vararg str: String) {
        Napier.w(str.joinToString(" "))
    }

    fun error(vararg str: String) {
        Napier.e(str.joinToString(" "))
    }

}