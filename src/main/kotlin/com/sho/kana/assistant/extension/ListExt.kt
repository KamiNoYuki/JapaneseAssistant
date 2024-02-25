package com.sho.kana.assistant.extension

import java.util.*

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/22 17:16:51
 * @description  List扩展函数文件
 **/


/**
 * 从集合随机抽取元素进行听写
 */
fun <T> MutableList<T>.startDictation(onFinish:(() -> Unit)? = null, onDictation: (target: Pair<Int, T>) -> Unit) {
    randomEleIndexed()?.let {
        onDictation(it)
        removeAt(it.first)
    }
    if(isNotEmpty()) {
        startDictation(onDictation = onDictation)
    } else {
        onFinish?.invoke()
        println(">>>>> 听写完毕 <<<<<")
    }
}

/**
 * 从列表随机选择一个元素并返回其下标和元素对象
 */
fun<T> List<T>.randomEleIndexed() =
    takeIf {
        it.isNotEmpty()
    }?.let {
        val index = Random().nextInt(size)
        index to it[index]
    }

/**
 * 从列表随机选择一个元素的下标
 */
fun <T> List<T>.randomEleIndex() = randomEleIndexed()?.first

/**
 * 从列表随机选择一个元素
 */
fun <T> List<T>.randomEle() = randomEleIndexed()?.second