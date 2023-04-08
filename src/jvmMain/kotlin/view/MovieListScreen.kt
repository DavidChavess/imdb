import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import model.Movie

@Composable
fun movieListScreen(movies: List<Movie>) {
    LazyVerticalGrid(GridCells.Adaptive(150.dp)) {
        items(movies) {
            renderMovie(it)
        }
    }
}