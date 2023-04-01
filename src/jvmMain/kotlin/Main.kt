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
    val movie = Movie(
        "3-D Man",
        6.5f,
        "The Super Hero",
        "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg",
        2000
    )
    val movie2 = Movie(
        "A-Bomb (HAS)",
        7.5f,
        "The Super Hero",
        "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg",
        1998
    )
    val movie3 = Movie(
        "A.I.M.",
        6.5f,
        "The Super Hero",
        "http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec.jpg",
        2010
    )

    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {
                listOf(movie, movie2, movie3, movie, movie2, movie3)
                    .let { movies ->
                        LazyColumn {
                            items(items = movies, itemContent = { movie ->
                                renderMovie(movie)
                            })
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