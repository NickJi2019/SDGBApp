package com.sbga.sdgbapp.Net

import com.sbga.sdgbapp.Net.Packet.Packet
import com.sbga.sdgbapp.Net.VO.NetQuery

object NetPacketUtil {
    fun getUserAgent(query: NetQuery<*, *>): String {
        if (query.UserId != 0uL) {
            return "${Packet.obfuscator(query.api)}#${query.UserId}"
        }
        return Packet.obfuscator(query.api) + "#" + NetConfig.clientId
    }
}