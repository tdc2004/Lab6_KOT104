package com.chinhdev.lab6_kot104

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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.unit.sp
import com.chinhdev.lab6_kot104.model.Movie
import com.chinhdev.lab6_kot104.ui.theme.Lab6_KOT104Theme
import com.chinhdev.lab6_kot104.ui.theme.PreviewCinemaSeatBooking

class MainActivity : ComponentActivity() {
    var movies = listOf(
        Movie(
            "Thám tử lừng danh Conan",
            "180",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKDF4BeYYPBmrhn-dIiJWY9AWLb6QGWBT8AA&s",
            "Thám tử lừng danh Conan: Tàu ngầm sắt màu đen là phim điện ảnh anime trinh thám năm 2023 của Nhật Bản dựa trên nguyên tác là bộ manga Thám tử lừng danh Conan của họa sĩ Aoyama Gōshō. Phim do Yuzuru Tachikawa làm đạo diễn, dựa trên phần kịch bản do Takeharu Sakurai.",
            "30/5/2024"
        ),
        Movie(
            "Thám tử lừng danh Conan",
            "180",
            "https://upload.wikimedia.org/wikipedia/vi/d/d9/ConanMovie24.jpg",
            "Thám tử lừng danh Conan: Tàu ngầm sắt màu đen là phim điện ảnh anime trinh thám năm 2023 của Nhật Bản dựa trên nguyên tác là bộ manga Thám tử lừng danh Conan của họa sĩ Aoyama Gōshō. Phim do Yuzuru Tachikawa làm đạo diễn, dựa trên phần kịch bản do Takeharu Sakurai.",
            "30/5/2024"
        ),
        Movie(
            "Thám tử lừng danh Conan",
            "180",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmQ6iunusOpRM-NrvGPPd_Ci8zLjsyH8HtWQ&s",
            "Thám tử lừng danh Conan: Tàu ngầm sắt màu đen là phim điện ảnh anime trinh thám năm 2023 của Nhật Bản dựa trên nguyên tác là bộ manga Thám tử lừng danh Conan của họa sĩ Aoyama Gōshō. Phim do Yuzuru Tachikawa làm đạo diễn, dựa trên phần kịch bản do Takeharu Sakurai.",
            "30/5/2024"
        ),
        Movie(
            "Thám tử lừng danh Conan",
            "180",
            "https://vnw-img-cdn.popsww.com/api/v2/containers/file2/cms_topic/thumbnail_title-26e9b90ef88e-1673596885484-zIaO8hfx.png?v=0",
            "Thám tử lừng danh Conan: Tàu ngầm sắt màu đen là phim điện ảnh anime trinh thám năm 2023 của Nhật Bản dựa trên nguyên tác là bộ manga Thám tử lừng danh Conan của họa sĩ Aoyama Gōshō. Phim do Yuzuru Tachikawa làm đạo diễn, dựa trên phần kịch bản do Takeharu Sakurai.",
            "30/5/2024"
        ),
        Movie(
            "Thám tử lừng danh Conan",
            "180",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKDF4BeYYPBmrhn-dIiJWY9AWLb6QGWBT8AA&s",
            "Thám tử lừng danh Conan: Tàu ngầm sắt màu đen là phim điện ảnh anime trinh thám năm 2023 của Nhật Bản dựa trên nguyên tác là bộ manga Thám tử lừng danh Conan của họa sĩ Aoyama Gōshō. Phim do Yuzuru Tachikawa làm đạo diễn, dựa trên phần kịch bản do Takeharu Sakurai.",
            "30/5/2024"
        ),
        Movie(
            "Thám tử lừng danh Conan",
            "180",
            "https://upload.wikimedia.org/wikipedia/vi/d/d9/ConanMovie24.jpg",
            "Thám tử lừng danh Conan: Tàu ngầm sắt màu đen là phim điện ảnh anime trinh thám năm 2023 của Nhật Bản dựa trên nguyên tác là bộ manga Thám tử lừng danh Conan của họa sĩ Aoyama Gōshō. Phim do Yuzuru Tachikawa làm đạo diễn, dựa trên phần kịch bản do Takeharu Sakurai.",
            "30/5/2024"
        ),
        Movie(
            "Thám tử lừng danh Conan",
            "180",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmQ6iunusOpRM-NrvGPPd_Ci8zLjsyH8HtWQ&s",
            "Thám tử lừng danh Conan: Tàu ngầm sắt màu đen là phim điện ảnh anime trinh thám năm 2023 của Nhật Bản dựa trên nguyên tác là bộ manga Thám tử lừng danh Conan của họa sĩ Aoyama Gōshō. Phim do Yuzuru Tachikawa làm đạo diễn, dựa trên phần kịch bản do Takeharu Sakurai.",
            "30/5/2024"
        ),
        Movie(
            "Thám tử lừng danh Conan",
            "180",
            "https://vnw-img-cdn.popsww.com/api/v2/containers/file2/cms_topic/thumbnail_title-26e9b90ef88e-1673596885484-zIaO8hfx.png?v=0",
            "Thám tử lừng danh Conan: Tàu ngầm sắt màu đen là phim điện ảnh anime trinh thám năm 2023 của Nhật Bản dựa trên nguyên tác là bộ manga Thám tử lừng danh Conan của họa sĩ Aoyama Gōshō. Phim do Yuzuru Tachikawa làm đạo diễn, dựa trên phần kịch bản do Takeharu Sakurai.",
            "30/5/2024"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab6_KOT104Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MovieScreen(movies = movies)
                    PreviewCinemaSeatBooking()
                }
            }
        }
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

@Composable
fun MovieScreen(movies: List<Movie>) {
    var listType by remember { mutableStateOf(ListType.ROW) }
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
        when (listType) {
            ListType.ROW -> MovieListRow(movies)
            ListType.COLUMN -> MovieListColumn(movies)
            ListType.GRID -> MovieListGrid(movies)
        }
    }
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
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Normal)) {
                append(label)
            }
            withStyle(style = SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)) {
                append(value)
            }
        }
    )
}

@Composable
fun MovieItemColumn(movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor =
            Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation =
            6.dp
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
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,

                    overflow = TextOverflow.Ellipsis

                )
                BoldValueText(label = "Thời lượng: ", value = movie.time + "'")
                BoldValueText(label = "Khởi chiếu: ", value = movie.startUp)
                Text(
                    text = "Tóm tắt nội dung",

                    style = MaterialTheme.typography.bodySmall,

                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        top = 4.dp, bottom =
                        2.dp
                    )
                )
                Text(
                    text = movie.describe,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 5,

                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 2.dp)
                )
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
                            topEnd = 8.dp, topStart =
                            8.dp
                        )
                    ),
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = movie.title, style =
                    MaterialTheme.typography.titleSmall, maxLines = 2
                )
                BoldValueText(label = "Thời lượng: ", value = movie.time + "'")
                BoldValueText(label = "Khởi chiếu: ", value = movie.startUp)
            }
        }
    }
}

