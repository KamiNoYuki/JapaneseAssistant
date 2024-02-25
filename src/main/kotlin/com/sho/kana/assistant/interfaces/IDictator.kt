package com.sho.kana.assistant.interfaces

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/25 10:25:58
 * @description  听写器接口类
 **/
interface IDictator<T> {

    /**
     * 词典文件名（默认从resources目录下加载词典文件）
     */
    fun getDictionaryFileName(): String

    /**
     * 开始进行听写
     * @param wordList 单词列表
     */
    fun startDictation(wordList: T)
}