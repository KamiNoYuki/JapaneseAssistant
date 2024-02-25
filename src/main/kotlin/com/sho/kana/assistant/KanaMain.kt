package com.sho.kana.assistant

import com.sho.kana.assistant.constant.KANA_DIC_KANA_KEY
import com.sho.kana.assistant.dictator.RomaLettersDictatorImpl.Companion.ROMA_LETTERS_FROM_DIAL_TONE_HIRAGANA
import com.sho.kana.assistant.dictator.RomaLettersDictatorImpl.Companion.ROMA_LETTERS_FROM_DIAL_TONE_KATAKANA
import com.sho.kana.assistant.entity.Kana
import com.sho.kana.assistant.extension.timeStr
import com.sho.kana.assistant.utils.KanaDicUtils
import com.sho.kana.assistant.utils.KanaDicUtils.Companion.getRandomTypeStr
import com.sho.kana.assistant.utils.KanaDicUtils.Companion.randomKana
import java.util.*


val mode = KanaDicUtils.RandomType.KATAKANA

val onKanaDicLoadCompleted: ((kanaList: MutableMap<String, MutableList<Kana>>) -> Unit) by lazy {
    { kanaMap ->
//        //50音
        kanaMap[KANA_DIC_KANA_KEY]?.let { kanaList ->
            Scanner(System.`in`).apply {
                val random = Random()
                val errKanaList by lazy {
                    ArrayList<String>()
                }
                val startTime = System.currentTimeMillis()
                while (kanaList.isNotEmpty()) {
                    //随机选择一个假名
                    (kanaList).randomKana()?.let {
                        //在罗马字母听写模式下，随机选取平/片假名
                        val randomKanaType = random.nextInt(2)
                        val flag = when (mode) {
                            KanaDicUtils.RandomType.HIRAGANA,
                            KanaDicUtils.RandomType.KATAKANA -> it.second.letters

                            KanaDicUtils.RandomType.LETTERS ->
                                //罗马字母听写模式下随机选择平/片假名
                                if (randomKanaType == 0) {
                                    it.second.hiragana
                                } else {
                                    it.second.katakana
                                }
                        }
                        print("请写出[$flag]的${mode.getRandomTypeStr()}：")
                        val answer = next()
                        if (mode == KanaDicUtils.RandomType.LETTERS) {
                            if(answer == it.second.letters) {
                                print("答对啦！")
                            } else {
                                System.err.print("答错啦")
                                errKanaList.add(
                                    "(${it.second.letters})${
                                        if (randomKanaType == 0) {
                                            it.second.hiragana
                                        } else {
                                            it.second.katakana
                                        }
                                    }"
                                )
                            }
                        }
                        println(
                            "正确答案：[$flag]的${mode.getRandomTypeStr()}为${
                                when (mode) {
                                    KanaDicUtils.RandomType.HIRAGANA -> it.second.hiragana
                                    KanaDicUtils.RandomType.KATAKANA -> it.second.katakana

                                    KanaDicUtils.RandomType.LETTERS -> it.second.letters
                                }
                            }\n"
                        )
                        //移除听写过的假名
                        (kanaList as MutableList).remove(it.second)
                    }
                }
                if (mode == KanaDicUtils.RandomType.LETTERS) {
                    if (errKanaList.isNotEmpty()) {
                        System.err.println("共答错了${errKanaList.size}次，分别是：$errKanaList")
                    } else {
                        println("听写完全正确，恭喜恭喜！！")
                    }
                }

                println(">>> 听写完成${startTime?.let {
                    (System.currentTimeMillis() - it).timeStr()
                }} <<<")
            }
//            println("[50音列表]")
//            printKanaList(it)1
//            println()
//            println()
        }
//        //浊音
//        kanaMap[KANA_DIC_VOICED_SOUND_KEY]?.let {
//            println("[浊音列表]")
//            printKanaList(it)
//            println()
//        }
//        //半浊音
//        kanaMap[KANA_DIC_HALF_VOICED_KEY]?.let {
//            println("[半浊音列表]")
//            printKanaList(it)
//            println()
//        }
//        //拨音
//        kanaMap[KANA_DIC_DIAL_TONE_KEY]?.let {
//            println("[拨音列表]")
//            printKanaList(it)
//        }
    }
}

fun main() {
    KanaDicUtils.loadKanaDictionary(onCompleted = onKanaDicLoadCompleted) {
        System.err.println(it)
    }
//    checkFlags(ROMA_LETTERS_FROM_ALL_HIRAGANA)
}

fun checkFlags(flags: Int) {
    if (flags and ROMA_LETTERS_FROM_DIAL_TONE_HIRAGANA != 0) {
        // 含有拨音的平假名
        println("含有拨音的平假名")
    }
    if (flags and ROMA_LETTERS_FROM_DIAL_TONE_KATAKANA != 0) {
        // 含有拨音的片假名
        println("含有拨音的片假名")
    }
}

fun printKanaList(list: MutableList<Kana>) =
    list.forEach {
        print("${it.letters}(${it.hiragana},${it.katakana})\t")
        if (it.sn == 38 || it.sn == 43 || (it.sn in 1..38 && it.sn % 5 == 0)) {
            println()
        }
    }

