package com.sbga.sdgbapp

import com.sbga.sdgbapp.Aime.WechatAime
import com.sbga.sdgbapp.Net.Packet.Packet
import com.sbga.sdgbapp.Utility.Extensions.serialize
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun main() {

    val e = Exception("missing parameter")

    embeddedServer(Netty, port = 8080){
        routing {
            get("/"){
                call.respondText("Hello World!")
            }
            route("/api"){
                get("/get-userid"){
                    call.respondText(
                        WechatAime.getUserId(call.parameters["qrcode"] ?: throw e).serialize()
                    )
                }
                get("/login"){
                    call.respondText(
                        Packet.userLogin(call.parameters["uid"]?.toULong() ?: throw e, "",
                            false,0).serialize()
                    )
                }
                get("/logout"){
                    call.respondText(
                        Packet.userLogout(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-item"){
                    call.respondText(
                        Packet.getUserItem(
                            call.parameters["uid"]?.toULong() ?: throw e,
                            call.parameters["nextIndex"]?.toLong() ?: throw e).serialize()
                    )
                }
                get("/get-user-data"){
                    call.respondText(
                        Packet.getUserData(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-extend"){
                    call.respondText(
                        Packet.getUserExtend(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-option"){
                    call.respondText(
                        Packet.getUserOption(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-music"){
                    call.respondText(
                        Packet.getUserMusic(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-preview"){
                    call.respondText(
                        Packet.getUserPreview(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-chara"){
                    call.respondText(
                        Packet.getUserCharacter(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-ghost") {
                    call.respondText(
                        Packet.getUserGhost(
                            call.parameters["uid"]?.toULong() ?: throw e
                        ).serialize()
                    )
                }
                get("/get-user-activity"){
                    call.respondText(
                        Packet.getUserActivity(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-card"){
                    call.respondText(
                        Packet.getUserCard(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-map"){
                    call.respondText(
                        Packet.getUserMap(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-rating"){
                    call.respondText(
                        Packet.getUserRating(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-charge"){
                    call.respondText(
                        Packet.getUserCharge(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-course"){
                    call.respondText(
                        Packet.getUserCourse(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-favorite"){
                    call.respondText(
                        TODO()
                    )
                }
                get("/get-user-region"){
                    call.respondText(
                        Packet.getUserRegion(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-tuifen"){
                    call.respondText(
                        Packet.getUserRecommendRateMusic(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-portrait"){
                    call.respondText(
                        Packet.getUserPortrait(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-friend-season-ranking"){
                    call.respondText(
                        Packet.getUserFriendSeasonRanking(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-login-bonus"){
                    call.respondText(
                        Packet.getUserLoginBonus(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-recommend-selection-music"){
                    call.respondText(
                        Packet.getUserRecommendSelectionMusic(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/get-user-score-ranking"){
                    call.respondText(
                        Packet.getUserScoreRanking(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
                get("/ping"){
                    call.respondText(
                        Packet.ping().serialize()
                    )
                }
                get("/upsert-user-all"){
                    TODO()
                }

                get("/get-game-charge"){
                    call.respondText(
                        Packet.getGameCharge().serialize()
                    )
                }
                get("/get-game-event"){
                    call.respondText(
                        Packet.getGameEvent().serialize()
                    )
                }
                get("/get-game-ng-music-id"){
                    call.respondText(
                        Packet.getGameNgMusicId().serialize()
                    )
                }
                get("/get-game-ranking"){
                    call.respondText(
                        Packet.getGameRanking().serialize()
                    )
                }
                get("/get-game-setting"){
                    call.respondText(
                        Packet.getGameSetting().serialize()
                    )
                }
                get("/get-game-tournament-info"){
                    call.respondText(
                        Packet.getGameTournamentInfo().serialize()
                    )
                }
                get("/get-transfer-friend"){
                    call.respondText(
                        Packet.getTransferFriend(
                            call.parameters["uid"]?.toULong() ?: throw e).serialize()
                    )
                }
            }
        }
    }.start(wait = true)
}

