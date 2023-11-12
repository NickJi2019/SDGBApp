package com.sbga.sdgbapp.VO.Mai2

import com.sbga.sdgbapp.Manager.*
import com.sbga.sdgbapp.DB.*
import kotlinx.serialization.SerialName

import kotlinx.serialization.Serializable

@Serializable
data class UserOption(
    @SerialName("optionKind") var optionKind: OptionKindID,
    @SerialName("noteSpeed") var noteSpeed: OptionNotespeedID,
    @SerialName("slideSpeed") var slideSpeed: OptionSlidespeedID,
    @SerialName("touchSpeed") var touchSpeed: OptionTouchspeedID,
    @SerialName("tapDesign") var tapDesign: OptionGametapID,
    @SerialName("holdDesign") var holdDesign: OptionGameholdID,
    @SerialName("slideDesign") var slideDesign: OptionGameslideID,
    @SerialName("starType") var starType: OptionStartypeID,
    @SerialName("outlineDesign") var outlineDesign: OptionGameoutlineID,
    @SerialName("noteSize") var noteSize: OptionNotesizeID,
    @SerialName("slideSize") var slideSize: OptionSlidesizeID,
    @SerialName("touchSize") var touchSize: OptionTouchsizeID,
    @SerialName("starRotate") var starRotate: OptionStarrotateID,
    @SerialName("dispCenter") var dispCenter: OptionCenterdisplayID,
    @SerialName("dispChain") var dispChain: OptionDispchainID,
    @SerialName("dispRate") var dispRate: OptionDisprateID,
    @SerialName("dispBar") var dispBar: OptionDispbarlineID,
    @SerialName("touchEffect") var touchEffect: OptionToucheffectID,
    @SerialName("submonitorAnimation") var submonitorAnimation: OptionSubmonitorID,
    @SerialName("submonitorAchive") var submonitorAchive: OptionSubmonAchiveID,
    @SerialName("submonitorAppeal") var submonitorAppeal: OptionAppealID,
    @SerialName("matching") var matching: OptionMatchingID,
    @SerialName("trackSkip") var trackSkip: OptionTrackskipID,
    @SerialName("brightness") var brightness: OptionMoviebrightnessID,
    @SerialName("mirrorMode") var mirrorMode: OptionMirrorID,
    @SerialName("dispJudge") var dispJudge: OptionDispjudgeID,
    @SerialName("dispJudgePos") var dispJudgePos: OptionDispjudgeposID,
    @SerialName("dispJudgeTouchPos") var dispJudgeTouchPos: OptionDispjudgetouchposID,
    @SerialName("adjustTiming") var adjustTiming: OptionJudgetimingID,
    @SerialName("judgeTiming") var judgeTiming: OptionJudgetimingID,
    @SerialName("ansVolume") var ansVolume: OptionVolumeAnswerSoundID,
    @SerialName("tapHoldVolume") var tapHoldVolume: OptionVolumeID,
    @SerialName("criticalSe") var criticalSe: OptionCriticalID,
    @SerialName("tapSe") var tapSe: OptionTapSuccessSeID,
    @SerialName("breakSe") var breakSe: OptionBreakseID,
    @SerialName("breakVolume") var breakVolume: OptionVolumeID,
    @SerialName("exSe") var exSe: OptionExseID,
    @SerialName("exVolume") var exVolume: OptionVolumeID,
    @SerialName("slideSe") var slideSe: OptionSlideseID,
    @SerialName("slideVolume") var slideVolume: OptionVolumeID,
    @SerialName("touchHoldVolume") var touchHoldVolume: OptionVolumeID,
    @SerialName("damageSeVolume") var damageSeVolume: OptionVolumeID,
    @SerialName("headPhoneVolume") var headPhoneVolume: OptionHeadphonevolumeID,
    @SerialName("sortTab") var sortTab: SortTabID,
    @SerialName("sortMusic") var sortMusic: SortMusicID,
)
