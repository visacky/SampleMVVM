package com.example.samplemvvm.data.api

import com.example.samplemvvm.data.api.apiresponse.ArticleResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RetrofitEndpoint {
    @GET("mock/articles.json")
    fun getDataUsageListAsync(): Deferred<ArticleResponse>
}