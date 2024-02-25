package com.sho.kana.assistant.utils

import com.sho.kana.assistant.constant.JP_WORD_DIC_FILE_NAME
import com.sho.kana.assistant.entity.JpWord
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import java.io.File

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/22 15:21:05
 * @description  单词字典加载工具
 **/
class WordDicUtils {
    companion object {

        fun loadJpWordDic(onFailed: ((msg: Throwable) -> Unit)? = null) = loadWordDic(JP_WORD_DIC_FILE_NAME, JpWord.serializer(), onFailed)

        fun <T> loadWordDic(dicName: String, serializer: KSerializer<T>, onFailed: ((msg: Throwable) -> Unit)? = null) =
            runCatching {
                Thread.currentThread()
                    .contextClassLoader
                    .getResource(dicName)
                    ?.path?.let {
                        val content = File(it).readText()
                        Json.decodeFromString(MapSerializer(String.serializer(), ListSerializer(serializer)), content)
                    }
            }.onFailure {
                onFailed?.invoke(it)
            }.getOrNull()
    }
}