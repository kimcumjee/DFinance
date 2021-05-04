package com.study.dfinance.retrofitClient

import com.study.dfinance.service.NewService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofitClient {
    private val BASE_URL = "https://newsapi.org"
    fun getRetrofitClient() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getNewsService(retrofit: Retrofit) : NewService {
        return retrofit.create(NewService::class.java)
    }
}