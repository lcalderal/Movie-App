package br.com.movieapp.framework.data.remote.response

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("name") val name: String = "",
    @SerializedName("id") val id: Int = 0
)