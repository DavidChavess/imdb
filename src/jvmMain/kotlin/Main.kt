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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import client.retrofit.RetrofitInit
import client.retrofit.character.CharacterRetrofitClient
import model.Movie
import service.character.impl.CharacterServiceImpl

fun main() = application {

    val retrofit = RetrofitInit(System.getenv("MARVEL_BASE_URL"))
    val characterRetrofitClient = CharacterRetrofitClient(retrofit.characterRetrofitService())
    val characterService = CharacterServiceImpl(characterRetrofitClient)

    var movies: List<Movie> by remember {
        mutableStateOf(emptyList())
    }

    characterService.findTop50MarvelCharacters {
        movies = it
    }

    Window(onCloseRequest = ::exitApplication, title = "imdb") {
        App(movies)
    }
}

@Composable
@Preview
fun App(movies: List<Movie>) {
    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(GridCells.Adaptive(150.dp)) {
                    items(movies) {
                        renderMovie(it)
                    }
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