package com.example.samplemvvm.data.api

import ArticleResponse
import com.example.samplemvvm.depinjection.BaseApplication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class ApiServiceRepository(private val apiService: RetrofitEndpoint) {
    lateinit var result: ArticleResponse
    fun getDataUsageList(): ArticleResponse {
        try {
            val jsonFileString = getJsonDataFromAsset()

            val gson = Gson()
            val articles = object : TypeToken<ArticleResponse>() {}.type

            result = gson.fromJson(jsonFileString, articles)

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return result
    }


    fun getJsonDataFromAsset(): String? {
        val jsonString: String
        try {
            jsonString = BaseApplication.appContext.assets.open("articles.json").bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}