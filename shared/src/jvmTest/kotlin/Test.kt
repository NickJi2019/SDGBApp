
import com.sbga.sdgbapp.Net.VO.NetQuery
import com.sbga.sdgbapp.Utility.CipherAESExtension.encrypt
import com.sbga.sdgbapp.Utility.CompressorExtension.deflate
import com.sbga.sdgbapp.Utility.CompressorExtension.inflate
import com.sbga.sdgbapp.Utility.MD5
import com.sbga.sdgbapp.VO.Mai2.UserLoginRequestVO
import com.sbga.sdgbapp.VO.VOSerializer
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.util.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test


class Test {
    @Test fun damn(){
        infix fun Any.damn(a:Any):String{
            return "damn"
        }
    }
    @Test
    fun aes() {
        println("hello".encrypt())
    }

    @Test
    fun log() {
        Napier.base(DebugAntilog())
        println("oi")

        Napier.v("verbose")
        Napier.d("debug")
        Napier.i("info ")
        Napier.w("warn ")
        Napier.e("error")
    }

    @Test
    fun serialize() {
        @Serializable
        class a(
            val name: String = "a"
        ) : VOSerializer()
        println(Json.encodeToString(a(name = "bonjour")))
//        println(NetQuery<GameChargeRequestVO,GameChargeResponseVO>("api",1u,GameChargeRequestVO(true)).getRequest())
        val query = NetQuery<UserLoginRequestVO, UserLoginRequestVO>(
            "UserLoginApi", 11029236u, UserLoginRequestVO(
                11029236u, "", 1, 1641, "A63E01D8972", (System.currentTimeMillis() / 1000), false, 0
            )
        )
        query.setResponse<UserLoginRequestVO>(
            """{"userId":11029236,"accessCode":"","regionId":1,"placeId":1641,"clientId":"A63E01D8972","dateTime":1700059321,"isContinue":false,"genericFlag":0}"""
        )
        (query.response as UserLoginRequestVO).apply {
            println(userId)
            println(accessCode)
            println(regionId)
            println(placeId)
            println(clientId)
            println(dateTime)
            println(isContinue)
            println(genericFlag)
        }
    }

    @Test
    fun md() {
        println(MD5.md5("hello").encodeBase64())
    }

    @Test
    fun compress() {
        var a = "hello".encodeToByteArray().onEach { print("$it ") }; println()
        var b = a.deflate().onEach { print("$it ") }; println()
        var c = b.inflate().onEach { print("$it ") }; println()
        assert(a.contentEquals(c))
        a = """@rem@rem Copyright 2015 the original author or authors.@rem@rem Licensed under the Apache License, Version 2.0 (the "License");@rem you may not use this file except in compliance with the License.@rem You may obtain a copy of the License at@rem@rem      https://www.apache.org/licenses/LICENSE-2.0@rem@rem Unless required by applicable law or agreed to in writing, software@rem distributed under the License is distributed on an "AS IS" BASIS,@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.@rem See the License for the specific language governing permissions and@rem limitations under the License.@rem@if "%DEBUG%"=="" @echo off@rem ##########################################################################@rem@rem  Gradle startup script for Windows@rem@rem ##########################################################################@rem Set local scope for the variables with windows NT shellif "%OS%"=="Windows_NT" setlocalset DIRNAME=%~dp0if "%DIRNAME%"=="" set DIRNAME=.@rem This is normally unusedset APP_BASE_NAME=%~n0set APP_HOME=%DIRNAME%@rem Resolve any "." and ".." in APP_HOME to make it shorter.for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi@rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"@rem Find java.exeif defined JAVA_HOME goto findJavaFromJavaHomeset JAVA_EXE=java.exe%JAVA_EXE% -version >NUL 2>&1if %ERRORLEVEL% equ 0 goto executeecho.echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.echo.echo Please set the JAVA_HOME variable in your environment to match theecho location of your Java installation.goto fail:findJavaFromJavaHomeset JAVA_HOME=%JAVA_HOME:"=%set JAVA_EXE=%JAVA_HOME%/bin/java.exeif exist "%JAVA_EXE%" goto executeecho.echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%echo.echo Please set the JAVA_HOME variable in your environment to match theecho location of your Java installation.goto fail:execute@rem Setup the command lineset CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar@rem Execute Gradle"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% "-Dorg.gradle.appname=%APP_BASE_NAME%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*:end@rem End local scope for the variables with windows NT shellif %ERRORLEVEL% equ 0 goto mainEnd:failrem Set variable GRADLE_EXIT_CONSOLE if you need the _script_ return code instead ofrem the _cmd.exe /c_ return code!set EXIT_CODE=%ERRORLEVEL%if %EXIT_CODE% equ 0 set EXIT_CODE=1if not ""=="%GRADLE_EXIT_CONSOLE%" exit %EXIT_CODE%exit /b %EXIT_CODE%:mainEndif "%OS%"=="Windows_NT" endlocal:omega
            """.encodeToByteArray().onEach { print("$it ") }; println()
        b = a.deflate().onEach { print("$it ") }; println()
        c = b.inflate().onEach { print("$it ") }; println()
        assert(a.contentEquals(c))
    }

    @Test
    fun http() {

//        runBlocking {
//            Packet().create(
//                NetQuery(
//                    "UserLoginApi", 11029236u,
//                    UserLoginRequestVO(
//                        11029236u, "", 1, 1641, "A63E01D8972", (System.currentTimeMillis() / 1000), false, 0
//                    )
//                )
//            ).query.getResponse<UserLoginResponseVO>()
//        }
    }
}