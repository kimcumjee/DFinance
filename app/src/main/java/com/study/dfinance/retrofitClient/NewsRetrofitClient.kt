package com.stock.d_finance.retrofitClient

import com.stock.d_finance.Service.NewService
import com.stock.d_finance.Service.OilService
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