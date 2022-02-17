import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
fun App() {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize().background(Color(0xFF212121)),
            contentAlignment = Alignment.Center,
        ) {
            val stopWatch = remember { Domain() }
            Presentation(
                formattedTime = stopWatch.formattedTime,
                onStartClick = stopWatch::start,
                onPauseClick = stopWatch::pause,
                onResetClick = stopWatch::reset
            )
        }
    }
}

fun main() = application {
    Window(
        state = WindowState(width = 260.dp, height = 210.dp),
        resizable = false,
        onCloseRequest = ::exitApplication,
        title = "Stopwatch",
        icon = painterResource(resourcePath = "stopwatch.svg"),
        alwaysOnTop = true
    ) {
        App()
    }
}
