package com.sbga.sdgbapp.Utility

object Log {
    private fun template(msg:String,level:String):String{
        return "${DateTime.getLocalDateTime()} $level $msg"
    }
    fun verbose(vararg str: Any?) {

        println(template(str.joinToString(" "), "[VERBOSE]"))
    }

    fun debug(vararg str: Any?) {
        println(template(str.joinToString(" "), "[ DEBUG ]"))
    }

    fun info(vararg str: Any?) {
        println(template(str.joinToString(" "), "[ INFO  ]"))
    }

    fun warn(vararg str: Any?) {
        println(template(str.joinToString(" "), "[ WARN  ]"))
    }

    fun error(vararg str: Any?) {
        println(template(str.joinToString(" "), "[ ERROR ]"))
    }

}

typealias log = Log