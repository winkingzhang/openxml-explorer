package org.zhangwenqing.openxmlexplorer.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SingleSelection {
    var selected: Any? by mutableStateOf(null)
}