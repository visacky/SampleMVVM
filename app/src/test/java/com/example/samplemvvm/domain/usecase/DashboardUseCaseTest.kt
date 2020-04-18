package com.example.samplemvvm.domain.usecase

import com.example.samplemvvm.data.api.ApiServiceRepository
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test

class DashboardUseCaseTest {


    private val apiServiceRepository: ApiServiceRepository = mock()
    private val objUseCase = DashboardUseCase(apiServiceRepository)

    @Test
    fun getDateTime(){
        val it = objUseCase.getDateTime("1586404611")
        assert(it.equals("04/09/2020"))
    }

}