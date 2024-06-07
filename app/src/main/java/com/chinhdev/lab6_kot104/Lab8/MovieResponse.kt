package com.chinhdev.lab6_kot104.Lab8

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("time") val time: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("describe") val describe: String,
    @SerializedName("startUp") val startUp: String
) {
}