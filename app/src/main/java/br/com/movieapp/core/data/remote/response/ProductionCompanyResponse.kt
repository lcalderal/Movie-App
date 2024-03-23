package br.com.movieapp.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProductionCompanyResponse(
    @SerializedName("logo_path") val logoPath: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("id") val id: Int = 0,
    @SerializedName("origin_country") val originCountry: String = ""
)