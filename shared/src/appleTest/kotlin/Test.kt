
import com.sbga.sdgbapp.Utility.*
import com.sbga.sdgbapp.VO.VOSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test

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
        MD5.md5("hello"). onEach { print("${it.toInt()} ") }
    }
    @Test fun crypt(){
        println()
        val b = "hello".encodeToByteArray().onEach { print("${it.toInt()} ") }
        println()
        val a = CipherAES.encrypt(b).onEach { print("${it.toInt()} ") }
        println()
        val c = CipherAES.decrypt(a).onEach { print("${it.toInt()} ") }
        println()
        val d={
            println()
            val b = "hellohellohellohellohello".encodeToByteArray().onEach { print("${it.toInt()} ") }
            println()
            val a = CipherAES.encrypt(b).onEach { print("${it.toInt()} ") }
            println()
            val c = CipherAES.decrypt(a).onEach { print("${it.toInt()} ") }
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

//    @Test fun request(){
//        runBlocking {
//            Packet().create(NetQuery<UserLoginRequestVO, UserLoginResponseVO>("UserLoginApi", 11029236u,
//                UserLoginRequestVO(11029236u, "", 1, 1641, "A63E01D8972", DateTime.getTimeStamp(), false, 0)
//            ))
//        }
//    }
}