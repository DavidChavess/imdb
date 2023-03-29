import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column {
            Text("John Wick 4 - Baba Yaga")
            Image(
                painter = painterResource("john_wick_4.jpg"),
                contentDescription = "John Wick 4",
                modifier = Modifier.width(200.dp).height(200.dp).align(Alignment.Start)
            )
            Text("Imdb: 9.8")
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "imdb",
        // state = rememberWindowState(width = 300.dp, height = 300.dp)
    ) {
        App()
    }
}

@Composable
fun configureButtons() {
    val count = remember { mutableStateOf(0) }

    Column(Modifier.fillMaxSize(), Arrangement.spacedBy(5.dp)) {
        Button(modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                count.value++
            }
        ) {
            Text(if (count.value == 0) "Click here" else "Clicked ${count.value}")
        }
        Button(modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                count.value = 0
            }
        ) {
            Text("Reset")
        }
    }
}
