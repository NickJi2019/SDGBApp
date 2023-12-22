package com.sbga.sdgbapp.Utility

object Log {
    private fun template(msg:String,level:String):String{
        return "${DateTime.getLocalDateTime()} $level $msg"
    }
    fun verbose(vararg str: Any?) {

        println(template(str.joinToString(" "), "[VERBO]"))
    }

    fun debug(vararg str: Any?) {
        println(template(str.joinToString(" "), "[DEBUG]"))
    }

    fun info(vararg str: Any?) {
        println(template(str.joinToString(" "), "\u001b[32m[INFO ]\u001b[0m"))
    }

    fun warn(vararg str: Any?) {
        println(template(str.joinToString(" "), "\u001b[33m[WARN ]\u001b[0m"))
    }

    fun error(vararg str: Any?) {
        println(template(str.joinToString(" "), "\u001b[31m[ERROR]\u001b[0m"))
    }


}

typealias log = Log