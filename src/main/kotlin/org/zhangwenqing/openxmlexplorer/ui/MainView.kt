package org.zhangwenqing.openxmlexplorer.ui

import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.zhangwenqing.openxmlexplorer.core.OpenXmlFile
import org.zhangwenqing.openxmlexplorer.models.Editors
import org.zhangwenqing.openxmlexplorer.models.Explorer
import org.zhangwenqing.openxmlexplorer.models.FileTree
import org.zhangwenqing.openxmlexplorer.models.Settings
import org.zhangwenqing.openxmlexplorer.utils.toProjectFile

@Composable
fun MainView() {
//    val homeFolder: OpenXmlFile = java.io.File(System.getProperty("user.home")).toProjectFile()
    val homeFolder: OpenXmlFile = java.io.File("/dummy").toProjectFile()
    val explorer = remember {
        val editors = Editors()

        Explorer(
            editors = editors,
            fileTree = FileTree(homeFolder, editors),
            settings = Settings(),
        )
    }

    DisableSelection {
        ExplorerView(explorer)
    }
}