package com.sbga.sdgbapp.Manager

enum class PlaySyncflagID(val value: Int) {
    None(0),
    ChainLow(1),
    ChainHi(2),
    SyncLow(3),
    SyncHi(4),
    Begin(0),
    End(5),
    Invalid(-1)
}
