import com.sbga.sdgbapp.Utility.*
import com.sbga.sdgbapp.Utility.Extensions.alsoLogArrI
import com.sbga.sdgbapp.Utility.Extensions.decrypt
import com.sbga.sdgbapp.Utility.Extensions.deflate
import com.sbga.sdgbapp.Utility.Extensions.deserialize
import com.sbga.sdgbapp.Utility.Extensions.encrypt
import com.sbga.sdgbapp.Utility.Extensions.inflate
import com.sbga.sdgbapp.Utility.Extensions.logI
import com.sbga.sdgbapp.Utility.Extensions.md5
import com.sbga.sdgbapp.Utility.Extensions.md5String
import com.sbga.sdgbapp.Utility.Extensions.serialize
import kotlinx.coroutines.*

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.*
import kotlin.test.Test

class Test {
    @Test fun log() {
        log.verbose("verbose")
        log.debug("debug")
        log.info("info ")
        log.warn("warn ")
        log.error("error")
    }
    @Test fun aes() {
        val plaintext = "hello".encodeToByteArray().alsoLogArrI()
        val ciphertext = plaintext.encrypt().alsoLogArrI()
        val decrypted = ciphertext.decrypt().alsoLogArrI()

        assertTrue(plaintext.contentEquals(decrypted))
    }

    @Test fun compress() {
        val original = "hello".encodeToByteArray().alsoLogArrI()
        val compressed = original.deflate().alsoLogArrI()
        val decompressed = compressed.inflate().alsoLogArrI()
        assertTrue(original.contentEquals(decompressed))
    }

    @Test fun date(){
        println(DateTime.getTokyoDateTime())
        println(DateTime.getTimeStamp())
        println(DateTime.getChinaDateTime())
        println(DateTime.getChinaDate())
        println(DateTime.getLocalDateTime())
    }

    @Test fun json() {
        @Serializable class A(val name: String)
        val clazz = A("bonjour")
        val serialized = clazz.serialize().logI()
        val deserialized = serialized.deserialize<A>().logI()
        assertEquals(clazz.name, deserialized.name)
    }

    @Test fun md() {
        assertEquals("hello".md5String().logI(),"5d41402abc4b2a76b9719d911017c592")
    }

    @Test fun http() {
        NetHttpClient("http://example.com").apply {
            requestSync(null, "".encodeToByteArray(), "GET")?.decodeToString().logI()
            finalize()
        }
        NetHttpClient("https://example.com").apply {
            requestSync(null, "".encodeToByteArray(), "GET")?.decodeToString().logI()
            finalize()
        }
    }
}