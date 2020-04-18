package com.example.samplemvvm.data.api

import com.example.samplemvvm.data.api.apiresponse.ArticleResdetail
import com.example.samplemvvm.data.api.apiresponse.ArticleResponse
import com.example.samplemvvm.extensions.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ApiServiceRepository(private val apiService: RetrofitEndpoint) {
    lateinit var result: ArticleResponse
    fun getDataUsageList(): ArticleResponse {
        try {
            val jsonFileString = getJsonDataFromAsset("articles.json")

            val gson = Gson()
            val articles = object : TypeToken<ArticleResponse>() {}.type

            result = gson.fromJson(jsonFileString, articles)

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return result
    }

    fun getDataUsageList(fileName: String): ArticleResdetail {
        var result: ArticleResdetail = ArticleResdetail()
        try {
            val jsonFileString = getJsonDataFromAsset(fileName)

            val gson = Gson()
            val articles = object : TypeToken<ArticleResdetail>() {}.type

            result = gson.fromJson(jsonFileString, articles)

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return result
    }
}