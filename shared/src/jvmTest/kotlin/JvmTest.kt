
import com.sbga.sdgbapp.Aime.WechatAime
import com.sbga.sdgbapp.Net.Packet.NetIO
import com.sbga.sdgbapp.Net.Packet.Packet
import com.sbga.sdgbapp.Net.VO.Mai2.UserLoginRequestVO
import com.sbga.sdgbapp.Net.VO.Mai2.UserLoginResponseVO
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Utility.*
import com.sbga.sdgbapp.Utility.Extensions.decrypt
import com.sbga.sdgbapp.Utility.Extensions.deflate
import com.sbga.sdgbapp.Utility.Extensions.encrypt
import com.sbga.sdgbapp.Utility.Extensions.inflate
import com.sbga.sdgbapp.Utility.Extensions.serialize
import com.sbga.sdgbapp.Utility.Extensions.sha256
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test


class JvmTest {
}