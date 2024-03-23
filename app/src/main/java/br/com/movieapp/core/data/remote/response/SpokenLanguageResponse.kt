package br.com.movieapp.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class SpokenLanguageResponse(
    @SerializedName("name") val name: String = "",
    @SerializedName("iso_639_1") val iso6391: String = "",
    @SerializedName("english_name") val englishName: String = ""
)