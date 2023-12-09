package com.codezync.movieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.codezync.movieapp.model.Movie
import com.codezync.movieapp.model.getMovies
import com.codezync.movieapp.widgets.MovieRow

@Composable
fun DetailScreen(navController: NavController, movieId: String?){
val movie = getMovies()

   val newMovieList = getMovies().filter { it.id == movieId } ?: throw IllegalArgumentException("Movie not found")

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Row(horizontalArrangement = Arrangement.Start) {

                Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Arrow Back" , modifier = Modifier.clickable { navController.popBackStack() })
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Detail")
            }

        }

    }) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {

            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                MovieRow(movie = newMovieList.first())
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                HorzontalScorollableImageView(newMovieList)
            }

            
        }

    }

}

@Composable
private fun HorzontalScorollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp,
            ) {
                Image(
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie Poster"
                )

            }
        }

    }
}
        

   
