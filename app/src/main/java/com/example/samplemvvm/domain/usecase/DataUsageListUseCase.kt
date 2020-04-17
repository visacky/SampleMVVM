package com.example.samplemvvm.domain.usecase

import ArticleResponse
import com.example.samplemvvm.data.api.ApiServiceRepository
import com.example.samplemvvm.data.api.apiresponse.ArticleResdetail
import com.example.samplemvvm.data.api.result.Result
import com.example.samplemvvm.data.api.result.ResultTypes


class DataUsageListUseCase(private val apiServiceRepo: ApiServiceRepository) {
    suspend fun getDataUsageList(
        onSuccess: (List<ArticleResdetail>?) -> Unit,
        onError: () -> Unit
    ) {
        val response = apiServiceRepo.getDataUsageList()
        onSuccess.invoke(prepareData(response))
    }

    fun prepareData(response: ArticleResponse): List<ArticleResdetail>? {

        /*
         For other scenarios we can handle the business logic here and its reusable we can use this
         usecase for other viewmodel also
         */
        return response.list
    }

}

