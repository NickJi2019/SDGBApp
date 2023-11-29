import com.sbga.sdgbapp.Utility.CipherAES
import com.sbga.sdgbapp.Utility.Compressor
import org.junit.Test

class Test {
    @Test
    fun aes() {
        println(println(CipherAES.encrypt("hello")))
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
}