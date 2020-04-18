package com.example.samplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplemvvm.data.api.apiresponse.ArticleResdetail
import com.example.samplemvvm.domain.usecase.ArticleDetailUseCase
import kotlinx.coroutines.launch

class ArticleDetailViewModel(private val articleDetailUseCase: ArticleDetailUseCase) : ViewModel() {

    val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var articleDetail: ArticleResdetail = ArticleResdetail()


    fun initAPIService(fileName: String) {
        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            articleDetailUseCase.getDetailArticle(fileName, {
                isLoadingLiveData.postValue(false)
                articleDetail = it
            }, {
                isLoadingLiveData.postValue(false)
            })
        }
    }
}