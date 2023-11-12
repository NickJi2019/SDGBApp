package com.sbga.sdgbapp.DB

enum class OptionCriticalID(val value: Int) {
    Default(0),
    CriticalOn(1),
    CriticalOnly(2),
    NotPerfect(3),
    Begin(0),
    End(4),
    Invalid(-1)
}
