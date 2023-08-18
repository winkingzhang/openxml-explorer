package org.zhangwenqing.openxmlexplorer.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.Regular
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.brands.Github
import compose.icons.fontawesomeicons.regular.Moon
import compose.icons.fontawesomeicons.solid.Sun
import java.awt.Desktop
import java.net.URI


@Composable
@Preview
fun AppView() {

    var darkTheme by remember { mutableStateOf(true) }
    var selectedFileName by remember { mutableStateOf("NoSelection.file") }

    Surface(modifier = Modifier.fillMaxSize()) {
        AppTheme(darkTheme) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(selectedFileName) },
                        backgroundColor = MaterialTheme.colors.primary,
                        navigationIcon = {
                            IconButton(
                                modifier = Modifier.padding(end = 5.dp),
                                onClick = { }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    modifier = Modifier.size(20.dp),
                                    contentDescription = null
                                )
                            }
                        },
                        actions = {
                            IconButton(
                                modifier = Modifier.padding(end = 5.dp),
                                onClick = {
                                    val desktop = if (Desktop.isDesktopSupported()) Desktop.getDesktop() else null
                                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                                        try {
                                            desktop.browse(URI.create("https://github.com/winkingzhang/openxml-explorer"))
                                        } catch (e: Exception) {
                                            e.printStackTrace()
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = FontAwesomeIcons.Brands.Github,
                                    modifier = Modifier.size(20.dp),
                                    contentDescription = null
                                )
                            }
                            IconButton(
                                modifier = Modifier.padding(end = 5.dp),
                                onClick = { /* show configure dialoig */ }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Settings,
                                    modifier = Modifier.size(20.dp),
                                    contentDescription = null
                                )
                            }
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        modifier = Modifier.size(36.dp).padding(2.dp),
                        onClick = {
                            darkTheme = !darkTheme;
                        }
                    ) {
                        Icon(
                            imageVector = if (darkTheme) FontAwesomeIcons.Solid.Sun else FontAwesomeIcons.Regular.Moon,
                            modifier = Modifier.size(14.dp),
                            tint = if (darkTheme) Color.White else Color.Black,
                            contentDescription = null
                        )
                    }
                }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        MainView()
                    }
                }
            }
        }
    }
}
