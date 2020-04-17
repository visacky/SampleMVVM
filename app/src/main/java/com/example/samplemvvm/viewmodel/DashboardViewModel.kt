package com.example.samplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplemvvm.data.api.apiresponse.ArticleResdetail
import com.example.samplemvvm.domain.usecase.DataUsageListUseCase
import kotlinx.coroutines.launch

class DashboardViewModel(private val dataUsageListUseCase: DataUsageListUseCase) : ViewModel()  {

    val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var articleList: List<ArticleResdetail> = listOf()


    init {
        initAPIService()
    }

    private fun initAPIService() {
        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            dataUsageListUseCase.getDataUsageList( {
                if(it != null)
                articleList = it
                isLoadingLiveData.postValue(false)
            }, {
                isLoadingLiveData.postValue(false)
            })
        }
    }
}