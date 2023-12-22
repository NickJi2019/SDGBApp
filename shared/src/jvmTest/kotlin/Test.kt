
import com.sbga.sdgbapp.Aime.WechatAime
import com.sbga.sdgbapp.Net.Packet.NetIO
import com.sbga.sdgbapp.Net.Packet.Packet
import com.sbga.sdgbapp.Net.VO.Mai2.UserLoginRequestVO
import com.sbga.sdgbapp.Net.VO.Mai2.UserLoginResponseVO
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Utility.*
import com.sbga.sdgbapp.Utility.Extensions.decrypt
import com.sbga.sdgbapp.Utility.Extensions.deflate
import com.sbga.sdgbapp.Utility.Extensions.encrypt
import com.sbga.sdgbapp.Utility.Extensions.inflate
import com.sbga.sdgbapp.Utility.Extensions.serialize
import com.sbga.sdgbapp.Utility.Extensions.sha256
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.util.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test


class Test {
    @Test
    fun aes() {
        println("hello".encrypt())
        println("hello".encrypt().decrypt())
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

        log.verbose("verbose")
        log.debug("debug")
        log.info("info ")
        log.warn("warn ")
        log.error("error")

    }

    @Test
    fun serialize() {
        @Serializable
        class a(
            val name: String = "a"
        )

        println(Json.encodeToString(a(name = "bonjour")))
    }

    @Test
    fun md() {
        println(MD5.md5("hello").encodeBase64())
    }

    @Test
    fun compress() {
        val a = "hello".encodeToByteArray().onEach { print("$it ") }; println()
        val b = a.deflate().onEach { print("$it ") }; println()
        val c = b.inflate().onEach { print("$it ") }; println()
        assert(a.contentEquals(c))
    }

    @Test
    fun http() {
        NetHttpClient("http://www.google.com").apply {
            request(mapOf("Accept" to "*/*"), "".encodeToByteArray(), "GET")
            getResponse().decodeToString().also { println(it) }
            finalize()
        }
    }


    @Test
    fun finalLogicTest() {
        NetIO.sendRequest(NetQuery<UserLoginRequestVO, UserLoginResponseVO>("UserLoginApi", 123456u).apply {
            request = UserLoginRequestVO(
                userId = 123456u,
                accessCode = "",
                regionId = 1,
                placeId = 1641,
                clientId = "A63E01D8972",
                dateTime = DateTime.getTimeStamp().toString(),
                isContinue = false,
                genericFlag = 0
            )
        }).also {
            println(it.response.serialize())
        }
    }

    @Test fun login(){
        Packet.userLogin(11029237u,"",false,0).let {
            log.info(it.returnCode)
            log.info(it.serialize())
        }
    }

    @Test fun sha256(){
        println("hello".sha256())
    }

    @Test fun wechatAime(){
        WechatAime.getUserId("damn").let {
            log.info(it.userID)
            log.info(it.serialize())
        }
    }
}