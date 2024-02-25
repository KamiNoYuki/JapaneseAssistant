package com.sho.kana.assistant.constant

import kotlinx.serialization.json.Json

const val KANA_DIC_FILE_NAME = "kana_dic.json"//假名词典文件名
const val JP_WORD_DIC_FILE_NAME = "learned_jp_words.json"//已学过的日语单词词典文件名
const val KANA_DIC_KANA_KEY = "kana"//平/片假名列表
const val KANA_DIC_DIAL_TONE_KEY = "dialTone"//拨音假名列表
const val KANA_DIC_VOICED_SOUND_KEY = "voicedSound"//浊音假名列表
const val KANA_DIC_HALF_VOICED_KEY = "halfVoiced"//半浊音假名列表

val json by lazy {
    Json {
        isLenient = true//宽松模式
        ignoreUnknownKeys = true //忽略未知键
    }
}

//    val kanaList = mutableMapOf(
//        "a" to ("あ" to "ア"),
//        "i" to ("い" to "イ"),
//        "u" to ("う" to "ウ"),
//        "e" to ("え" to "エ"),
//        "o" to ("お" to "オ"),
//        "ka" to ("か" to "カ"),
//        "ki" to ("き" to "キ"),
//        "ku" to ("く" to "ク"),
//        "ke" to ("け" to "ケ"),
//        "ko" to ("こ" to "コ"),
//        "sa" to ("さ" to "サ"),
//        "si" to ("し" to "シ"),
//        "su" to ("す" to "ス"),
//        "se" to ("せ" to "セ"),
//        "so" to ("そ" to "ソ"),
//        "ta" to ("た" to "タ"),
//        "ti" to ("ち" to "チ"),
//        "tu" to ("つ" to "ツ"),
//        "te" to ("て" to "テ"),
//        "to" to ("と" to "ト"),
//        "na" to ("な" to "ナ"),
//        "ni" to ("に" to "ニ"),
//        "nu" to ("ぬ" to "ヌ"),
//        "ne" to ("ね" to "ネ"),
//        "no" to ("の" to "ノ"),
//        "ha" to ("は" to "ハ"),
//        "hi" to ("ひ" to "ヒ"),
//        "hu" to ("ふ" to "ㇷ"),
//        "he" to ("へ" to "ヘ"),
//        "ho" to ("ほ" to "ホ"),
//        "ma" to ("ま" to "マ"),
//        "mi" to ("み" to "ミ"),
//        "mu" to ("む" to "ム"),
//        "me" to ("め" to "メ"),
//        "mo" to ("も" to "モ"),
//        "ya" to ("や" to "ヤ"),
//        "yu" to ("ゆ" to "ユ"),
//        "yo" to ("よ" to "ヨ"),
//        "ra" to ("ら" to "ラ"),
//        "ri" to ("り" to "リ"),
//        "ru" to ("る" to "ル"),
//        "re" to ("れ" to "ㇾ"),
//        "ro" to ("ろ" to "ロ"),
//        "wa" to ("わ" to "ワ"),
//        "wo" to ("を" to "ヲ"),
//        "n" to ("ん" to "ン")
//    )