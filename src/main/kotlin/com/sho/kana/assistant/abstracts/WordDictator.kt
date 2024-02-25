package com.sho.kana.assistant.abstracts

import com.sho.kana.assistant.extension.startDictation
import com.sho.kana.assistant.extension.timeStr
import com.sho.kana.assistant.interfaces.IDictator
import com.sho.kana.assistant.utils.WordDicUtils
import kotlinx.serialization.KSerializer

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/25 10:22:38
 * @description  单词听写器抽象类，负责实现听写逻辑而不关注单词词库的选择
 **/
abstract class WordDictator<T>(
    open val isTiming: Boolean = true, //是否启用听写计时
) : IDictator<List<T>> {

    protected abstract val serializer: KSerializer<T>

    protected open val wordsMap by lazy {
        loadThesaurus()
    }

    protected abstract var day: String?

    protected open fun loadThesaurus() = WordDicUtils.loadWordDic(getDictionaryFileName(), serializer) {
        it.printStackTrace()
    }

    protected open fun readWordsByDay(days: String) = wordsMap?.get(days)

    fun startDictation() = day.let { day ->
        if (day.isNullOrBlank()) {
            readWordsFromDic().apply {
            }?.let {
                startDictation(it)
            }
        } else {
            readWordsByDay(day)?.let { startDictation(it) }
        }
    }

    private fun readWordsFromDic() = wordsMap?.let {
        ArrayList<T>().apply {
            it.forEach {
                addAll(it.value)
            }
        }.toMutableList()
    }

    override fun startDictation(wordList: List<T>) {
        val startTime = System.currentTimeMillis()
        wordList.toMutableList()
            .apply {
                println("${day ?: "全部"}的待听写单词数量：$size")
            }
            .startDictation(onFinish = { onDicFinish() }) {
                doDictation(it.second)
            }
        if(isTiming) {
            println(timingFormat().format((System.currentTimeMillis() - startTime).timeStr()))
        }
    }

    protected open fun timingFormat() = "本次听写用时：%s"

    /**
     * 听写完成时回调
     */
    protected open fun onDicFinish() {

    }

    /**
     * 实现具体的听写过程
     * @param wordData 待听写的单词列表
     */
    protected abstract fun doDictation(wordData: T)
}