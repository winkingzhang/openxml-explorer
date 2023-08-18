package org.zhangwenqing.openxmlexplorer.core

object EmptyTextLines : TextLines {
    override val size: Int
        get() = 0

    override fun get(index: Int): String = ""
}