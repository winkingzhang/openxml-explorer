package org.zhangwenqing.openxmlexplorer.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ExpandableFile(
    val file: OpenXmlFile,
    val level: Int,
) {
    var children: List<ExpandableFile> by mutableStateOf(emptyList())
    val canExpand: Boolean get() = file.hasChildren

    fun toggleExpanded() {
        children = if (children.isEmpty()) {
            file.children
                .map { ExpandableFile(it, level + 1) }
                .sortedWith(compareBy({ it.file.isDirectory }, { it.file.name }))
                .sortedBy { !it.file.isDirectory }
        } else {
            emptyList()
        }
    }
}