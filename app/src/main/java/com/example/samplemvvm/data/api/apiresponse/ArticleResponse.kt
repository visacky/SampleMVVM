package com.example.samplemvvm.data.api.apiresponse

import com.google.gson.annotations.SerializedName

data class ArticleResponse (@SerializedName("data") val list : List<ArticleResdetail>)
