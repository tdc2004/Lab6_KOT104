package com.chinhdev.lab6_kot104.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies
    init {
        _movies.value = getSampleMovies()
    }
    private fun getSampleMovies(): List<Movie> {
        return listOf(
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
        )
    }
}