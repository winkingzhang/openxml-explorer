import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.zhangwenqing.openxmlexplorer.ui.AppView
import kotlin.system.exitProcess

fun main() {
    application {

        val icon = painterResource("logo.png")
        val windowState = rememberWindowState(width = 1280.dp, height = 720.dp)

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "OpenXML Explorer",
            icon = icon,
        ) {
            AppView()
        }
    }
    exitProcess(0)
}
