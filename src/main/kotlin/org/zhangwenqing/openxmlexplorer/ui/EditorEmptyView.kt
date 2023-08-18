package org.zhangwenqing.openxmlexplorer.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Code

@Composable
fun EditorEmptyView() = Box(Modifier.fillMaxSize()) {
    Column(Modifier.align(Alignment.Center)) {
        Icon(
            FontAwesomeIcons.Solid.Code,
            contentDescription = null,
            tint = LocalContentColor.current.copy(alpha = 0.60f),
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxSize(0.4f)
        )

        Text(
            "To view file open it from the file tree",
            color = LocalContentColor.current.copy(alpha = 0.75f),
            fontSize = 28.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(16.dp)
        )
    }
}