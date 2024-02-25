package com.sho.kana.assistant.entity

import kotlinx.serialization.Serializable

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/22 15:23:26
 * @description  日语单词实体类
 **/
@Serializable
data class JpWord(
    /**
     * 单词对应的假名
     */
    val kana: String,
    /**
     * 单词发音的音调
     */
    val tone: MutableList<Int>?,
    /**
     * 日语单词
     */
    val word: String,
    /**
     * 中文词义
     */
    val mean: String,
)