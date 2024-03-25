package br.com.movieapp.framework.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movieList: List<MovieResultResponse>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalMovies: Int
)