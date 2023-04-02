import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import model.Movie
import service.CharacterService
import service.impl.CharacterServiceImpl

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "imdb",
    ) {
        App()
    }
}

@Composable
@Preview
fun App() {
    val characterService: CharacterService = CharacterServiceImpl()
    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn {
                    items(items = characterService.findTop50MarvelCharacters(), itemContent = { movie ->
                        renderMovie(movie)
                    })
                }
            }
        }
    }
}

@Composable
fun renderMovie(movie: Movie) {
    Column(modifier = Modifier.width(200.dp).padding(22.dp, 14.dp)) {
        Image(
            bitmap = movie.imageSrc.loadImageBitmap(),
            contentDescription = movie.description,
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("${movie.imdb}")
            Text("${movie.year}")
        }
        Text(text = movie.name, modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}