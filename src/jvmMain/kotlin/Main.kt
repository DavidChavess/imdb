import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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

    var isLoading: Boolean by remember {
        mutableStateOf(true)
    }

    characterService.findTop50MarvelCharacters {
        movies = it
        isLoading = false
    }

    Window(onCloseRequest = ::exitApplication, title = "imdb") {
        App {
            if (isLoading) {
                loadMovieScreen()
            } else {
                movieListScreen(movies)
            }
        }
    }
}

@Composable
@Preview
fun App(content: @Composable () -> Unit) {
    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                content()
            }
        }
    }
}