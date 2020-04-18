package com.example.samplemvvm.domain.usecase

import com.example.samplemvvm.data.api.ApiServiceRepository
import com.example.samplemvvm.data.api.apiresponse.ArticleResdetail

class ArticleDetailUseCase(private val apiServiceRepo: ApiServiceRepository) {

    fun getDetailArticle(detailName : String,
        onSuccess: (ArticleResdetail) -> Unit,
        onError: () -> Unit
    ) {
        val response = apiServiceRepo.getDataUsageList(detailName)
        onSuccess.invoke(prepareData(response))
    }

    fun prepareData(response: ArticleResdetail): ArticleResdetail {

        /*
         For other scenarios we can handle the business logic here and its reusable we can use this
         usecase for other viewmodel also
         */
        return response
    }

}