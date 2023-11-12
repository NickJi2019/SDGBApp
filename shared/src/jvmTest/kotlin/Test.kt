import com.sbga.sdgbapp.Net.NetPacketUtil
import com.sbga.sdgbapp.Net.Packet.Packet
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Utility.CipherAES
import com.sbga.sdgbapp.Utility.MD5
import com.sbga.sdgbapp.VO.Mai2.UserLoginRequestVO
import com.sbga.sdgbapp.VO.Mai2.UserLoginResponseVO
import com.sbga.sdgbapp.VO.VOSerializer
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.util.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test


class Test {
    @Test
    fun aes() {
        println(println(CipherAES.encrypt("hello")))
    }

    @Test
    fun log() {
        Napier.base(DebugAntilog())
        println("oi")

        Napier.v("verbose")
        Napier.d("debug")
        Napier.i("info ")
        Napier.w("warn ")
        Napier.e("error")
    }

    @Test
    fun serialize() {
        @Serializable
        class a(
            val name: String = "a"
        ) : VOSerializer()
        println(Json.encodeToString(a(name = "bonjour")))
//        println(NetQuery<GameChargeRequestVO,GameChargeResponseVO>("api",1u,GameChargeRequestVO(true)).getRequest())

    }

    @Test
    fun md() {
        println(MD5.md5("hello").encodeBase64())
    }

    @Test
    fun http() {
        runBlocking {
            val query = NetQuery<UserLoginRequestVO, UserLoginResponseVO>(
                "UserLoginApi", 11029236u, UserLoginRequestVO(
                    11029236u, "", 1, 1641, "A63E01D8972", (System.currentTimeMillis() / 1000), false, 0
                )
            )
            Packet().apply {
                create<UserLoginRequestVO, UserLoginResponseVO>(query)
                println((this.query.response!! as UserLoginResponseVO).loginId)
            }

        }
        println(Packet.obfuscator("UserLoginApi"))
        println(
            NetPacketUtil.getUserAgent(
                NetQuery<UserLoginRequestVO, UserLoginResponseVO>("UserLoginApi", 11029236u, null)
            )
        )
    }
}