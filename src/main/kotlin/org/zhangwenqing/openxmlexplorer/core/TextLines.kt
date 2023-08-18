package org.zhangwenqing.openxmlexplorer.core

interface TextLines {
    val size: Int
    fun get(index: Int): String
}