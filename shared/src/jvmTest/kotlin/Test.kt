import com.sbga.sdgbapp.Net.Packet.Packet
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Utility.*
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
        val query = NetQuery<UserLoginRequestVO, UserLoginRequestVO>(
            "UserLoginApi", 11029236u, UserLoginRequestVO(
                11029236u, "", 1, 1641, "A63E01D8972", (System.currentTimeMillis() / 1000), false, 0
            )
        )
        query.setResponse<UserLoginRequestVO>(
            """{"userId":11029236,"accessCode":"","regionId":1,"placeId":1641,"clientId":"A63E01D8972","dateTime":1700059321,"isContinue":false,"genericFlag":0}"""
        )
        (query.response as UserLoginRequestVO).apply {
            println(userId)
            println(accessCode)
            println(regionId)
            println(placeId)
            println(clientId)
            println(dateTime)
            println(isContinue)
            println(genericFlag)
        }
    }

    @Test
    fun md() {
        println(MD5.md5("hello").encodeBase64())
    }

    @Test
    fun compress() {
        val b = "hello".encodeToByteArray()
        val a = Compressor.deflate(CipherAES.encrypt(b))
        println(b.joinToString(" "))
        println(CipherAES.encrypt(b).joinToString(" "))
        println(CipherAES.decrypt(CipherAES.encrypt(b)).joinToString(" "))
        println(Compressor.deflate(b).joinToString(" "))
        println(Compressor.inflate(Compressor.deflate(b)).joinToString(" "))
        val c = Compressor.inflate(Compressor.deflate(CipherAES.encrypt(b))).joinToString(" ")
        println(c)
//        val d = CipherAES.decrypt(Compressor.inflate(Compressor.deflate(CipherAES.encrypt(b))))
    }

    @Test
    fun http() {
        runBlocking {
            Packet().create(
                NetQuery(
                    "UserLoginApi", 11029236u,
                    UserLoginRequestVO(
                        11029236u, "", 1, 1641, "A63E01D8972", (System.currentTimeMillis() / 1000), false, 0
                    )
                )
            ).query.getResponse<UserLoginResponseVO>()
        }
    }
}