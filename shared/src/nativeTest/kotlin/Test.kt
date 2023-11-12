import com.sbga.sdgbapp.Utility.CipherAES
import com.sbga.sdgbapp.Utility.MD5
import com.sbga.sdgbapp.VO.VOSerializer
import io.ktor.util.*
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
        println(MD5.md5("hello").encodeBase64())
    }
}