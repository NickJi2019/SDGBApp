package com.sbga.sdgbapp.Utility

import kotlinx.datetime.*

object DateTime {
    fun getTimeStamp(): Long {
        return (Clock.System.now().toEpochMilliseconds() / 1000)
    }

    fun getLocalDateTime(): String {
        val dateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return "${dateTime.date} ${dateTime.time.hour.toString().padStart(2, '0')}:${dateTime.time.minute.toString().padStart(2, '0')}:${dateTime.time.second.toString().padStart(2, '0')}:${(dateTime.time.nanosecond / 1_000_000).toString().padStart(3, '0')}"
    }

    fun getChinaDateTime(): String {
        val time = Clock.System.now().toLocalDateTime(TimeZone.of("Asia/Shanghai"))
        return "${time.year.toString().substring(2)}${time.monthNumber.toString().padStart(2, '0')}${time.date.dayOfMonth.toString().padStart(2, '0')}${time.hour.toString().padStart(2, '0')}${time.minute.toString().padStart(2, '0')}${time.second.toString().padStart(2, '0')}"
    }

    fun getChinaDate(): String {
        return Clock.System.todayIn(TimeZone.of("Asia/Shanghai")).toString()
    }

    fun getTokyoDateTime(): String {
        val time = Clock.System.now().toLocalDateTime(TimeZone.of("Asia/Tokyo"))
        return "${time.year.toString().substring(2)}${time.monthNumber.toString().padStart(2, '0')}${time.date.dayOfMonth.toString().padStart(2, '0')}${time.hour.toString().padStart(2, '0')}${time.minute.toString().padStart(2, '0')}${time.second.toString().padStart(2, '0')}"
    }
}