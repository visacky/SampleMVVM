package com.example.samplemvvm.depinjection

import com.example.samplemvvm.data.api.ApiServiceRepository
import com.example.samplemvvm.data.api.RetrofitEndpoint
import com.example.samplemvvm.domain.usecase.ArticleDetailUseCase
import com.example.samplemvvm.domain.usecase.DashboardUseCase
import com.example.samplemvvm.viewmodel.ArticleDetailViewModel
import com.example.samplemvvm.viewmodel.DashboardViewModel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

@ExperimentalCoroutinesApi
object BaseModule {

    val mainModule = module {
        factory { provideApiService(get()) }
        factory { ApiServiceRepository(apiService = get()) }
        factory { DashboardUseCase(apiServiceRepo = get()) }
        factory { ArticleDetailUseCase(apiServiceRepo = get()) }
        viewModel { DashboardViewModel(dashboardUseCase = get()) }
        viewModel { ArticleDetailViewModel(articleDetailUseCase = get()) }
    }

    private fun provideApiService(retrofit: Retrofit): RetrofitEndpoint {
        return retrofit.create(RetrofitEndpoint::class.java)
    }

}