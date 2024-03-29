package org.zhangwenqing.openxmlexplorer.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.CoroutineScope
import org.zhangwenqing.openxmlexplorer.core.EmptyTextLines
import org.zhangwenqing.openxmlexplorer.core.OpenXmlFile

class Editor(
    val fileName: String,
    val lines: (backgroundScope: CoroutineScope) -> Lines,
) {
    var close: (() -> Unit)? = null
    lateinit var selection: SingleSelection

    val isActive: Boolean
        get() = selection.selected === this

    fun activate() {
        selection.selected = this
    }

    companion object {
        fun createEditor(openXmlFile: OpenXmlFile) = Editor(
            fileName = openXmlFile.name
        ) { backgroundScope ->
            val textLines = try {
                openXmlFile.readLines(backgroundScope)
            } catch (e: Throwable) {
                e.printStackTrace()
                EmptyTextLines
            }
            val isCode = openXmlFile.name.endsWith(".kt", ignoreCase = true)

            fun content(index: Int): Editor.Content {
                val text = textLines.get(index)
                val state = mutableStateOf(text)
                return Editor.Content(state, isCode)
            }

            object : Editor.Lines {
                override val size get() = textLines.size

                override fun get(index: Int) = Editor.Line(
                    number = index + 1,
                    content = content(index)
                )
            }
        }
    }

    class Content(val value: State<String>, val isCode: Boolean)
    class Line(val number: Int, val content: Content)

    interface Lines {
        val lineNumberDigitCount: Int get() = size.toString().length
        val size: Int
        operator fun get(index: Int): Line
    }
}

