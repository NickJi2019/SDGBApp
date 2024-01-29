import com.sbga.sdgbapp.Utility.*
import com.sbga.sdgbapp.Utility.Extensions.logI
import kotlin.test.Test

class AppleTest {
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