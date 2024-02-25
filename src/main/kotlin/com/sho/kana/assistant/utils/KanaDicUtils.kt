package com.sho.kana.assistant.utils

import com.sho.kana.assistant.constant.KANA_DIC_FILE_NAME
import com.sho.kana.assistant.constant.json
import com.sho.kana.assistant.entity.Kana
import com.sho.kana.assistant.extension.randomEleIndexed
import java.io.File

/**
 * 假名词典工具类
 */
class KanaDicUtils {
    enum class RandomType {
        /**
         * 随机平假名模式
         */
        HIRAGANA,

        /**
         * 随机片假名模式
         */
        KATAKANA,

        /**
         * 随机罗马字母模式
         */
        LETTERS
    }

    companion object {
        /**
         * 读取假名词典文件
         * @param isSortBySn 是否根据sn进行升序排序，默认true
         * @param onCompleted 加载成功时回调
         * @param onFailed 加载失败时回调
         */
        fun loadKanaDictionary(
            isSortBySn: Boolean = true,
            onCompleted: ((kanaList: MutableMap<String, MutableList<Kana>>) -> Unit),
            onFailed: ((msg: String) -> Unit)
        ) {
            runCatching {
                Thread.currentThread()
                    .contextClassLoader
                    .getResource(KANA_DIC_FILE_NAME)
                    ?.path?.let {
                        val content = File(it).readText()
                        json.decodeFromString<MutableMap<String, MutableList<Kana>>>(content)
                    }
            }.onSuccess { kanaMap ->
                if (kanaMap.isNullOrEmpty()) {
                    onFailed("假名词典无内容！")
                } else {
                    onCompleted(kanaMap.run {
                        if (isSortBySn) {
                            forEach { kanaMap ->
                                this[kanaMap.key]?.let {
                                    this[kanaMap.key] = sortBySn(it)
                                }
                            }
                        }
                        this
                    })
                }
            }.onFailure {
                onFailed(it.message ?: "假名词典加载失败！")
            }
        }

        /**
         * 随机返回一个片假名和其下标
         */
        fun List<Kana>.randomKatakana() = randomByType(RandomType.KATAKANA)

        /**
         * 随机返回一个平假名和其下标
         */
        fun List<Kana>.randomHiragana() = randomByType(RandomType.HIRAGANA)

        /**
         * 随机返回一个假名的罗马字母
         */
        fun List<Kana>.randomKanaLetters() = randomByType(RandomType.LETTERS)

        /**
         * 根据随机选择类型随机抽取假名
         * @param randomType 随机选取的类型，具体可参考：[com.sho.kana.assistant.utils.KanaDicUtils.RandomType]
         */
        fun List<Kana>.randomByType(randomType: RandomType) =
            randomKana()
                ?.let {
                    it.first to it.second.run {
                        when (randomType) {
                            RandomType.HIRAGANA -> this.hiragana
                            RandomType.KATAKANA -> this.katakana
                            RandomType.LETTERS -> this.letters
                        }
                    }
                }

        /**
         * 随机返回一个假名和其下标
         */
        fun List<Kana>.randomKana() = randomEleIndexed()

        fun RandomType.getRandomTypeStr() =
            when(this) {
                RandomType.HIRAGANA -> "平假名"
                RandomType.KATAKANA -> "片假名"
                RandomType.LETTERS -> "罗马字母"
            }

        private fun sortBySn(list: MutableList<Kana>) = ArrayList(list.sortedBy { it.sn })
    }
}