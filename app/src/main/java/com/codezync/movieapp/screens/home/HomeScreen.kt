package com.codezync.movieapp.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codezync.movieapp.model.Movie
import com.codezync.movieapp.model.getMovies
import com.codezync.movieapp.navigation.MovieScreens
import com.codezync.movieapp.navigation.MovieScreens.Companion.fromRoute
import com.codezync.movieapp.widgets.MovieRow


@Composable
fun HomeScreen(navController : NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
            Text(text = "Movies")
        }

    }) {
        MainContent(navController = navController)
    }
}


    @Composable
    fun MainContent(
        navController: NavController,
        movieList: List<Movie> = getMovies()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn()
            {
                items(items = movieList)
                {
                    MovieRow(movie = it) {movie->
                        navController.navigate(route = MovieScreens.DetailScreen.name+"/${movie}")
                    }
                }
            }

        }
    }






