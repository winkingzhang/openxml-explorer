package org.zhangwenqing.openxmlexplorer.models

import androidx.compose.runtime.mutableStateListOf
import org.zhangwenqing.openxmlexplorer.core.OpenXmlFile

class Editors {

    private val selection = SingleSelection()

    var editors = mutableStateListOf<Editor>()
        private set

    val active: Editor? get() = selection.selected as Editor?

    fun open(openXmlFile: OpenXmlFile) {
        val editor = Editor.createEditor(openXmlFile)
        editor.selection = selection
        editor.close = {
            close(editor)
        }
        editors.add(editor)
        editor.activate()
    }

    private fun close(editor: Editor) {
        val index = editors.indexOf(editor)
        editors.remove(editor)
        if (editor.isActive) {
            selection.selected = editors.getOrNull(index.coerceAtMost(editors.lastIndex))
        }
    }
}