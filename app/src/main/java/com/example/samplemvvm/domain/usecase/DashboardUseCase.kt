package com.example.samplemvvm.domain.usecase

import com.example.samplemvvm.data.api.ApiServiceRepository
import com.example.samplemvvm.data.api.apiresponse.ArticleResdetail
import com.example.samplemvvm.data.api.apiresponse.ArticleResponse
import java.text.SimpleDateFormat
import java.util.*


class DashboardUseCase(private val apiServiceRepo: ApiServiceRepository) {
    fun getDataUsageList(
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

        val list = response.list.sortedByDescending { it.lastUpdate }
        list.forEach {
            it.lastUpdate = getDateTime(it.lastUpdate)
        }

        return list
    }

    fun getDateTime(timestamp : String) : String{
        val mydate = Calendar.getInstance()
        mydate.setTimeInMillis(timestamp.toLong() * 1000)
        return SimpleDateFormat("MM/dd/yyyy").format(mydate.time)
    }

}

