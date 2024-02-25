package com.sho.kana.assistant.extension

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/24 21:27:10
 * @description  时间相关的扩展函数
 **/

fun Long.timeStr(): String {
    val totalSeconds = this / 1000
    val seconds = totalSeconds % 60
    val totalMinutes = totalSeconds / 60
    val minutes = totalMinutes % 60
    val hours = totalMinutes / 60
    val milliseconds = if (hours > 0 || minutes > 0 || seconds > 0) 0 else this % 1000

    return buildString {
        if (hours > 0) append("${hours}时")
        if (hours > 0 || minutes > 0) append("${minutes}分")
        if (hours > 0 || minutes > 0 || seconds > 0) append("${seconds}秒")
        if (milliseconds > 0) append("${milliseconds}毫秒")
    }
}