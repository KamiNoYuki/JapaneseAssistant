package com.sho.kana.assistant.dictator

import com.sho.kana.assistant.abstracts.WordDictator
import com.sho.kana.assistant.constant.JP_WORD_DIC_FILE_NAME
import com.sho.kana.assistant.entity.JpWord
import com.sho.kana.assistant.enums.JpWordDicType
import kotlinx.serialization.KSerializer
import java.util.*

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/25 10:53:41
 * @description  日语单词听写器实现类
 **/
class JpWordDictatorImpl(
    override var day: String? = null, //要听写第几天的单词，为空则默认听写词库的所有单词
    override val serializer: KSerializer<JpWord> = JpWord.serializer(),
    private val type: JpWordDicType = JpWordDicType.ALL //听写模式
) : WordDictator<JpWord>() {

    private val scanner by lazy { Scanner(System.`in`) }

    override fun doDictation(wordData: JpWord) {
        val question = when (type) {
            JpWordDicType.WORD -> "单词" to wordData.word
            JpWordDicType.KANA -> "假名" to wordData.kana
            JpWordDicType.ALL -> "声调、假名和单词" to "${wordData.tone}(${wordData.kana})${wordData.word}"
        }
        print("请写出[${wordData.mean}]的日语[${question.first}]：")
        scanner.next()
        println("正确答案：\n[${wordData.mean}]的日语[${question.first}]为：${question.second}\n")
    }

    override fun timingFormat() = "本次${day ?: "全部"}单词听写用时：%s"

    override fun onDicFinish() {
        scanner.close()
    }

    override fun getDictionaryFileName() = JP_WORD_DIC_FILE_NAME
}