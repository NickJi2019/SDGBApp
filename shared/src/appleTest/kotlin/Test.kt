import com.sbga.sdgbapp.Utility.CipherAES
import kotlin.test.Test

class Test {
    @Test
    fun aes() {
        println(println(CipherAES.encrypt("hello")))
    }
}