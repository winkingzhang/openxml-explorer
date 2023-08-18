package org.zhangwenqing.openxmlexplorer.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.*
import org.zhangwenqing.openxmlexplorer.models.FileTree
import org.zhangwenqing.openxmlexplorer.utils.withoutWidthConstraints

@Composable
fun FileTreeViewTabView() = Row(
    Modifier.padding(8.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Text(
        "Files",
        color = LocalContentColor.current.copy(alpha = 0.60f),
        fontSize = 12.sp,
        modifier = Modifier.padding(horizontal = 4.dp)
    )
}

@Composable
fun FileTreeView(model: FileTree) = Surface(
    modifier = Modifier.fillMaxSize()
) {
    with(LocalDensity.current) {
        Box {
            val scrollState = rememberLazyListState()

            LazyColumn(
                modifier = Modifier.fillMaxSize().withoutWidthConstraints(),
                state = scrollState
            ) {
                items(model.items.size) {
                    FileTreeItemView(14.sp, 14.sp.toDp() * 1.5f, model.items[it])
                }
            }

            VerticalScrollbar(
                Modifier.align(Alignment.CenterEnd),
                scrollState
            )
        }
    }
}

@Composable
fun FileTreeEmptyView() = Box(Modifier.fillMaxSize()) {
    Column(Modifier.align(Alignment.Center)) {
        Icon(
            FontAwesomeIcons.Solid.Tree,
            contentDescription = null,
            tint = LocalContentColor.current.copy(alpha = 0.60f),
            modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxSize(0.4f)
        )

        Text(
            "Open an OpenXML file to reveal content tree",
            color = LocalContentColor.current.copy(alpha = 0.75f),
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(20.dp)
        )
    }
}

@Composable
private fun FileTreeItemView(fontSize: TextUnit, height: Dp, model: FileTree.Item) = Row(
    modifier = Modifier
        .wrapContentHeight()
        .clickable { model.open() }
        .padding(start = 24.dp * model.level)
        .height(height)
        .fillMaxWidth()
) {
    val interactionSource = remember { MutableInteractionSource() }
    val active by interactionSource.collectIsHoveredAsState()

    FileItemIcon(Modifier.align(Alignment.CenterVertically), model)
    Text(
        text = model.name,
        color = if (active) LocalContentColor.current.copy(alpha = 0.60f) else LocalContentColor.current,
        modifier = Modifier
            .align(Alignment.CenterVertically)
            .clipToBounds()
            .hoverable(interactionSource),
        softWrap = true,
        fontSize = fontSize,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
private fun FileItemIcon(modifier: Modifier, model: FileTree.Item) = Box(modifier.size(24.dp).padding(4.dp)) {
    when (val type = model.type) {
        is FileTree.ItemType.Folder -> when {
            !type.canExpand -> Unit
            type.isExpanded -> Icon(
                Icons.Default.KeyboardArrowDown, contentDescription = null, tint = LocalContentColor.current
            )

            else -> Icon(
                Icons.Default.KeyboardArrowRight, contentDescription = null, tint = LocalContentColor.current
            )
        }

        is FileTree.ItemType.File -> when (type.ext) {
            "xml" -> Icon(FontAwesomeIcons.Solid.Code, contentDescription = null, tint = Color(0xFFC19C5F))
            "txt" -> Icon(FontAwesomeIcons.Solid.Edit, contentDescription = null, tint = Color(0xFF87939A))
            "png" -> Icon(FontAwesomeIcons.Solid.Image, contentDescription = null, tint = Color(0xFF62B543))
            else -> Icon(FontAwesomeIcons.Solid.File, contentDescription = null, tint = Color(0xFF87939A))
        }
    }
}

//@Composable
//fun VerticalScrollbar(
//    modifier: Modifier,
//    scrollState: ScrollState
//) = androidx.compose.foundation.VerticalScrollbar(
//    rememberScrollbarAdapter(scrollState),
//    modifier
//)

@Composable
fun VerticalScrollbar(
    modifier: Modifier,
    scrollState: LazyListState
) = androidx.compose.foundation.VerticalScrollbar(
    rememberScrollbarAdapter(scrollState),
    modifier
)