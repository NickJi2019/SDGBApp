package com.sbga.sdgbapp.Utility

import kotlinx.datetime.*
object DateTime {
    fun getTimeStamp(): Long {
        return (Clock.System.now().toEpochMilliseconds() / 1000)
    }

    fun getDateTime(): String {
        val dateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        return "${dateTime.date} ${dateTime.time.hour.toString().padStart(2, '0')}:${dateTime.time.minute.toString().padStart(2, '0')}:${dateTime.time.second.toString().padStart(2, '0')}.0"
    }

    fun getDate(): String {
        return Clock.System.todayAt(TimeZone.currentSystemDefault()).toString()
    }

    fun getTokyoDateTime(): String {
        val tokyoDateTime = Clock.System.now().toLocalDateTime(TimeZone.of("Asia/Tokyo"))
        return "${tokyoDateTime.year.toString().substring(2)}${tokyoDateTime.monthNumber.toString().padStart(2, '0')}${tokyoDateTime.date.dayOfMonth.toString().padStart(2, '0')}${tokyoDateTime.hour.toString().padStart(2, '0')}${tokyoDateTime.minute.toString().padStart(2, '0')}${tokyoDateTime.second.toString().padStart(2, '0')}"
    }
}