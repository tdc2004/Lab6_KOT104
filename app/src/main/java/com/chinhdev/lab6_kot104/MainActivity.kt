package com.chinhdev.lab6_kot104

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chinhdev.lab6_kot104.Bai2Lab7.ScreenNavigation
import com.chinhdev.lab6_kot104.Bai3Lab7.HandleLoginState
import com.chinhdev.lab6_kot104.Bai3Lab7.LoginScreen
//import com.chinhdev.lab6_kot104.model.MainViewModel
import com.chinhdev.lab6_kot104.model.Movie
import com.chinhdev.lab6_kot104.model.MovieViewModel
import com.chinhdev.lab6_kot104.ui.theme.Lab6_KOT104Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6_KOT104Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //bai 1 lab7
//                    val navController = rememberNavController()
//                    val mainViewModel: MainViewModel = viewModel()
//                    val moviesState =
//                        mainViewModel.movies.observeAsState(initial = emptyList())
//                    MovieScreen(moviesState.value, navController)
                    //bai 2 lab 7
                    ScreenNavigation()

                    //bai 3 lab 7

//                    ScreenNavigation()

//                    MovieScreen(movies = movies)
//                    PreviewCinemaSeatBooking()
                }
            }
        }
    }
}

@Composable
fun Example(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Composable
fun MovieListRow(movies: List<Movie>) {
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index])
        }
    }
}

@Composable
fun MovieListGrid(movies: List<Movie>) {
    val gridState = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        state = gridState,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index])
        }
    }
}

enum class ListType {
    ROW, COLUMN, GRID
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieScreen() {
    val movieViewModel: MovieViewModel = viewModel()
    val moviesState = movieViewModel.movies.observeAsState(initial = emptyList())
    val movies = moviesState.value
    var showDialog by remember { mutableStateOf(false) }
    var listType by remember { mutableStateOf(ListType.ROW) }
    if (showDialog) {
        AddMovieDialog(
            onDismiss = { showDialog = false },
            onAddMovie = { title, time, startUp, describe, imageUrl ->
                movieViewModel.addMovie(
                    Movie(
                        id = "",
                        title = title,
                        time = time,
                        startUp = startUp,
                        describe = describe,
                        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKDF4BeYYPBmrhn-dIiJWY9AWLb6QGWBT8AA&s"
                    )
                )
                showDialog = false
            }
        )
    }
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { showDialog = true }) {
            Icon(Icons.Default.Add, contentDescription = "Add")
        }
    }, content = {
        Column(
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { listType = ListType.ROW }) {
                    Text("Row")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { listType = ListType.COLUMN }) {
                    Text("Column")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { listType = ListType.GRID }) {
                    Text("Grid")
                }
            }

            // Bài 1

            when (listType) {
                ListType.ROW -> MovieListRow(movies)
                ListType.COLUMN -> MovieListColumn(movies)
                ListType.GRID -> MovieListGrid(movies)
            }


        }
    })


}

@Composable
fun MovieListColumn(movies: List<Movie>) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItemColumn(movie = movies[index])
        }
    }
}

@Composable
fun BoldValueText(label: String, value: String) {
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal)) {
            append(label)
        }
        withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
            append(value)
        }
    })
}

@Composable
fun MovieItemColumn(movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(120.dp)
                    .wrapContentHeight()
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = movie.title, style = MaterialTheme.typography.titleSmall, maxLines = 2,
                    overflow = TextOverflow.Ellipsis

                )
                BoldValueText(label = "Thời lượng: ", value = movie.time + "'")
                BoldValueText(label = "Khởi chiếu: ", value = movie.startUp)
                Text(
                    text = "Tóm tắt nội dung",

                    style = MaterialTheme.typography.bodySmall,

                    fontWeight = FontWeight.Bold, modifier = Modifier.padding(
                        top = 4.dp, bottom = 2.dp
                    )
                )
                Text(
                    text = movie.describe, style = MaterialTheme.typography.bodySmall, maxLines = 5,

                    overflow = TextOverflow.Ellipsis, modifier = Modifier.padding(end = 2.dp)
                )

                Row(
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    IconButton(onClick = {}, modifier = Modifier.padding(10.dp)) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    IconButton(onClick = {}, modifier = Modifier.padding(10.dp)) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun MovieItem(movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .width(175.dp)
                .height(330.dp)
        ) {
            AsyncImage(
                model = movie.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(255.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topEnd = 8.dp, topStart = 8.dp
                        )
                    ),
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = movie.title, style = MaterialTheme.typography.titleSmall, maxLines = 2
                )
                BoldValueText(label = "Thời lượng: ", value = movie.time + "'")
                BoldValueText(label = "Khởi chiếu: ", value = movie.startUp)
            }
        }
    }
}
@SuppressLint("UnrememberedMutableState")
@Composable
fun AddMovieDialog(
    onDismiss: () -> Unit,
    onAddMovie: (title: String, time: String, startUp: String, describe: String, imageUrl: String) -> Unit
) {
    val title = mutableStateOf("")
    val time = mutableStateOf("")
    val startUp = mutableStateOf("")
    val describe = mutableStateOf("")
    val imageUrl = mutableStateOf("")

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Thêm Phim Mới") },
        confirmButton = {
            Button(
                onClick = {
                    onAddMovie(
                        title.value,
                        time.value,
                        startUp.value,
                        describe.value,
                        imageUrl.value
                    )
                    onDismiss()
                }
            ) {
                Text(text = "Thêm")
            }
        },
        dismissButton = {
            Button(
                onClick = { onDismiss() }
            ) {
                Text(text = "Hủy")
            }
        },
        text = {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                OutlinedTextField(
                    value = title.value,
                    onValueChange = { title.value = it },
                    label = { Text("Tiêu đề") },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                OutlinedTextField(
                    value = time.value,
                    onValueChange = { time.value = it },
                    label = { Text("Thời lượng") },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                OutlinedTextField(
                    value = startUp.value,
                    onValueChange = { startUp.value = it },
                    label = { Text("Khởi chiếu") },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                OutlinedTextField(
                    value = describe.value,
                    onValueChange = { describe.value = it },
                    label = { Text("Tóm tắt nội dung") },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                OutlinedTextField(
                    value = imageUrl.value,
                    onValueChange = { imageUrl.value = it },
                    label = { Text("URL ảnh") },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    )
}