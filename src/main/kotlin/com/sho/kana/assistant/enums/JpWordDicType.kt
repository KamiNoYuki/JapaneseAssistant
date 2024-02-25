package com.sho.kana.assistant.enums

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/24 20:52:25
 * @description  日语单词听写模式
 **/
enum class JpWordDicType {
    /**
     * 假名听写模式
     */
    KANA,
    /**
     * 单词听写模式
     */
    WORD,
    /**
     * 假名和单词、发声都听写的模式
     */
    ALL
}

fun JpWordDicType.isWordDicType() = this == JpWordDicType.WORD
fun JpWordDicType.isKanaDicType() = this == JpWordDicType.KANA
fun JpWordDicType.isAllDicType() = this == JpWordDicType.ALL