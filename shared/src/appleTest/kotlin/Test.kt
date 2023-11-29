import com.sbga.sdgbapp.Utility.*
import com.sbga.sdgbapp.VO.VOSerializer
import io.ktor.util.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import platform.zlib.*
import platform.Foundation.*
import kotlinx.coroutines.*
import kotlinx.cinterop.*
import cocoapods.DataCompression.*
import com.sbga.sdgbapp.Net.Packet.Packet
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.VO.Mai2.UserLoginRequestVO
import com.sbga.sdgbapp.VO.Mai2.UserLoginResponseVO

class Test {
    @Test
    fun aes() {
        println(CipherAES.encrypt("hello"))
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
        println(MD5.md5("hello").encodeBase64())
    }
    @Test fun crypt(){
        println(CipherAES.encrypt("hello".encodeToByteArray()).joinToString(" "))
    }


    @Test
    fun compress() {
        val b = "hello".encodeToByteArray().onEach { print("${it.toInt()} ") }
        println()
        val a = Compressor.deflate(b).onEach { print("${it.toInt()} ") }
        println()
        val c = Compressor.inflate(a).onEach { print("${it.toInt()} ") }
    }

    @Test fun request(){
        runBlocking {
            Packet().create(NetQuery<UserLoginRequestVO, UserLoginResponseVO>("UserLoginApi", 11029236u,
                UserLoginRequestVO(11029236u, "", 1, 1641, "A63E01D8972", DateTime.getTimeStamp(), false, 0)
            ))
        }
    }
}