package org.zhangwenqing.openxmlexplorer.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import org.zhangwenqing.openxmlexplorer.models.Editor
import org.zhangwenqing.openxmlexplorer.models.Settings

@Composable
fun EditorView(model: Editor, settings: Settings) = key(model) {

}