package com.example.samplemvvm.data.api.apiresponse

import com.google.gson.annotations.SerializedName

data class ArticleResdetail(
    @SerializedName("id") val id: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("text") val text: String = "",
    @SerializedName("last_update") var lastUpdate: String = "",
    @SerializedName("detail_name") val detailName: String = "",
    @SerializedName("short_description") val description: String = "",
    @SerializedName("avatar") val image: String = ""
)
