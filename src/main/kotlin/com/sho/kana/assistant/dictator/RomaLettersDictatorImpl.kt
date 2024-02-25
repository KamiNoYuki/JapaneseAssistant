package com.sho.kana.assistant.dictator

/**
 * @project  KanaAssistant
 * @author   Sho Tan.
 * @e-mail   2943343823@qq.com
 * @created 2024/2/22 10:53:44
 * @description  罗马字母听写器实现
 **/
class RomaLettersDictatorImpl {
    companion object {
        /**
         * 随机抽取50音中的平假名进行听写
         */
        const val ROMA_LETTERS_FROM_HIRAGANA = 0x01

        /**
         * 随机抽取50音中的片假名进行听写
         */
        const val ROMA_LETTERS_FROM_KATAKANA = 0x02

        /**
         * 用拨音的平假名听写
         */
        const val ROMA_LETTERS_FROM_DIAL_TONE_HIRAGANA = 0x04

        /**
         * 用拨音的片假名听写
         */
        const val ROMA_LETTERS_FROM_DIAL_TONE_KATAKANA = 0x08

        /**
         * 浊音中选取平假名进行听写
         */
        const val ROMA_LETTERS_FROM_VOICED_SOUND_HIRAGANA = 0x10

        /**
         * 浊音中选取片假名进行听写
         */
        const val ROMA_LETTERS_FROM_VOICED_SOUND_KATAKANA = 0x20

        /**
         * 半浊音中选取平假名进行听写
         */
        const val ROMA_LETTERS_FROM_HALF_VOICED_HIRAGANA = 0x40

        /**
         * 半浊音中选取片假名进行听写
         */
        const val ROMA_LETTERS_FROM_HALF_VOICED_KATAKANA = 0x80

        /**
         * 拗音中选取平假名进行听写
         */
        const val ROMA_LETTERS_FROM_OBSTINATE_SOUND_HIRAGANA = 0x100

        /**
         * 拗音中选取片假名进行听写
         */
        const val ROMA_LETTERS_FROM_OBSTINATE_SOUND_KATAKANA = 0x200

        /**
         * 所有假名中随机抽取平假名进行听写
         */
        const val ROMA_LETTERS_FROM_ALL_HIRAGANA = ROMA_LETTERS_FROM_HIRAGANA or
                                                   ROMA_LETTERS_FROM_DIAL_TONE_HIRAGANA or
                                                   ROMA_LETTERS_FROM_VOICED_SOUND_HIRAGANA or
                                                   ROMA_LETTERS_FROM_HALF_VOICED_HIRAGANA or
                                                   ROMA_LETTERS_FROM_OBSTINATE_SOUND_HIRAGANA
        /**
         * 所有假名中随机抽取片假名进行听写
         */
        const val ROMA_LETTERS_FROM_ALL_KATAKANA = ROMA_LETTERS_FROM_KATAKANA or
                                                   ROMA_LETTERS_FROM_DIAL_TONE_KATAKANA or
                                                   ROMA_LETTERS_FROM_VOICED_SOUND_KATAKANA or
                                                   ROMA_LETTERS_FROM_HALF_VOICED_KATAKANA or
                                                   ROMA_LETTERS_FROM_OBSTINATE_SOUND_KATAKANA
        /**
         * 从所有假名中随机抽取平/片假名进行听写
         */
        const val ROMA_LETTERS_FROM_ALL = ROMA_LETTERS_FROM_ALL_HIRAGANA or
                                          ROMA_LETTERS_FROM_ALL_KATAKANA
    }
}