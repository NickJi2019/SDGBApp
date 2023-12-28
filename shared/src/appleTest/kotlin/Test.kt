
import com.sbga.sdgbapp.Aime.WechatAime
import com.sbga.sdgbapp.Net.Packet.NetIO
import com.sbga.sdgbapp.Net.Packet.Packet
import com.sbga.sdgbapp.Net.VO.Mai2.UserLoginRequestVO
import com.sbga.sdgbapp.Net.VO.Mai2.UserLoginResponseVO
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Net.VO.VOSerializer
import com.sbga.sdgbapp.Utility.*
import com.sbga.sdgbapp.Utility.Extensions.decrypt
import com.sbga.sdgbapp.Utility.Extensions.encrypt
import com.sbga.sdgbapp.Utility.Extensions.serialize
import com.sbga.sdgbapp.Utility.Extensions.sha256
import com.sbga.sdgbapp.Utility.NetHttpClient.Companion.toCFDictionary
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import platform.CFNetwork.kCFStreamSSLLevel
import platform.CFNetwork.kCFStreamSSLValidatesCertificateChain
import platform.CoreFoundation.kCFBooleanFalse
import platform.CoreFoundation.kCFStreamSocketSecurityLevelNegotiatedSSL
import kotlin.test.Test

class Test {
    @Test fun log(){
        log.warn("w")
        log.info("i")
        log.error("e")
    }
    @Test
    fun aes() {
        println("hello".encrypt())
    }

    @Test
    fun serialize() {
        @Serializable
        class a(
            val name: String = "a"
        ) : VOSerializer()
        println(Json.encodeToString(a(name = "bonjour")))
        println(Json.encodeToString(a(name = "bonjour")).length)

    }

    @Test
    fun md() {
        MD5.md5("hello"). onEach { print("${it.toInt()} ") }
    }
    @Test fun crypt(){
        println()
        val b = "hello".encodeToByteArray().onEach { print("${it.toInt()} ") }
        println()
        val a = b.encrypt().onEach { print("${it.toInt()} ") }
        println()
        val c = a.decrypt().onEach { print("${it.toInt()} ") }
        println()
        val d={
            println()
            val b = "hellohellohellohellohello".encodeToByteArray().onEach { print("${it.toInt()} ") }
            println()
            val a = b.encrypt().onEach { print("${it.toInt()} ") }
            println()
            val c = a.decrypt().onEach { print("${it.toInt()} ") }
            println()
        }
        d()
    }


    @Test
    fun compress() {
        val b = "hello".encodeToByteArray().onEach { print("${it.toInt()} ") }
        println()
        val a = Compressor.deflate(b).onEach { print("${it.toInt()} ") }
        println()
        val c = Compressor.inflate(a).onEach { print("${it.toInt()} ") }
    }

    @Test fun http() {

    }
    @Test fun finalLogicTest() {
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
        Packet.userLogin(11029236u,"",false,0).let {
            log.info(it.returnCode)
            log.info(it.serialize())
        }
    }
    @Test fun sha256(){
        println("hello".sha256())
    }
    @Test fun wechatAime(){
        val qr="SGWCMAID2312281012342F40811DDEF27367BBFF80EC8F514B5995C0A4C21975CA61A3A6964446B3049F"
        WechatAime.getUserId(qr).let {
            log.info(it.userID)
            log.info(it.serialize())
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    @Test fun cfdict(){
        val sslSettings = mapOf(
            kCFStreamSSLValidatesCertificateChain to kCFBooleanFalse as CPointer<*>,
            kCFStreamSSLLevel to kCFStreamSocketSecurityLevelNegotiatedSSL as CPointer<*>
        ).toCFDictionary()
    }
}