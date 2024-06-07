package com.chinhdev.lab6_kot104.Lab8

import com.chinhdev.lab6_kot104.model.Movie


    fun MovieResponse.toMovie(): Movie {
        return Movie(
            id = this.id,          // Ánh xạ từ filmId của MovieResponse
            title = this.title,     // Ánh xạ từ filmName của MovieResponse
            time = this.time,      // Ánh xạ từ duration của MovieResponse
            imageUrl = this.imageUrl,     // Ánh xạ từ image của MovieResponse
            describe = this.describe, // Ánh xạ từ description của MovieResponse
            startUp = this.startUp // Ánh xạ từ releaseDate của MovieResponse
        )
    }
