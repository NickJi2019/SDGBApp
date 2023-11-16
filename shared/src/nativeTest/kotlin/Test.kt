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

    @OptIn(ExperimentalForeignApi::class)
    @Test
    fun zstream() {
        sizeOf<z_stream>()

    }

    @Test
    fun compress() {
        val b = "hello".encodeToByteArray()
        val a = Compressor.deflate(CipherAES.encrypt(b))
        val c = Compressor.inflate(Compressor.deflate(CipherAES.encrypt(b)))
        val d = CipherAES.decrypt(Compressor.inflate(Compressor.deflate(CipherAES.encrypt(b))))
    }

}