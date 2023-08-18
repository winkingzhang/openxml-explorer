package org.zhangwenqing.openxmlexplorer.core

import kotlinx.coroutines.CoroutineScope

interface OpenXmlFile {
    val name: String
    val isDirectory: Boolean
    val children: List<OpenXmlFile>
    val hasChildren: Boolean

    fun readLines(scope: CoroutineScope): TextLines
}