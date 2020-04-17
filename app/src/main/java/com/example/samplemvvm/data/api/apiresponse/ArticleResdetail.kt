package com.example.samplemvvm.data.api.apiresponse

import com.google.gson.annotations.SerializedName

data class ArticleResdetail(@SerializedName("id") val help : String,
                             @SerializedName("title") val title : String,
                             @SerializedName("last_update") val lastUpdate : String,
                             @SerializedName("short_description") val description : String,
                             @SerializedName("avatar") val image : String)
