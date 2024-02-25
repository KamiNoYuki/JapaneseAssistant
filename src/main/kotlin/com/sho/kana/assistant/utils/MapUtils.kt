package com.sho.kana.assistant.utils

import java.util.*

class MapUtils {
    companion object {
        fun <K, V> MutableMap<K, V>.randomKey() =
            takeIf {
                it.isNotEmpty()
            }?.let {
                Random().nextInt(keys.size)
                    .coerceAtMost(keys.size)
                    .let {
                        it to keys.toMutableList()[it]
                    }
            }

        fun Map<String, Pair<String, String>>.toJsonString() =
            StringBuilder().let { appender ->
                var index = 1
                forEach {
                    val formatter =
                        """
{
    "sn": $index,
    "romaChar": "${it.key}",
    "hiragana": "${it.value.first}",
    "katakana": "${it.value.second}"
}""".trimIndent()
                    if (appender.isNotBlank()) {
                        appender.append(",\n")
                    }
                    appender.append(formatter)
                    index++
                }
                appender.toString()
            }
    }
}