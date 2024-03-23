package br.com.movieapp.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class TotalMovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movieList: List<MovieResponse>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalMovies: Int
)