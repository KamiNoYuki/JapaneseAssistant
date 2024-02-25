package com.sho.kana.assistant.entity

import kotlinx.serialization.Serializable

/**
 * 假名实体类
 */
@Serializable
data class Kana(
    val sn: Int,//该假名在50音图的位置，用于排序使用
    val letters: String,//假名的罗马字母
    val hiragana: String,//对应的平假名
    val katakana: String//对应的片假名
)