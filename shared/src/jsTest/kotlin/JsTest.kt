import kotlin.test.Test

class JsTest {
    @Test
    fun aes() {
        js("require('crypto-js')")
    }

}