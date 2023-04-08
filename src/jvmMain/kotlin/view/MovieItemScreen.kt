import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Movie

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