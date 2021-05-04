package com.stock.d_finance.retrofitClient

import com.stock.d_finance.Service.OilService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OilRetrofitClient {
    private val BASE_URL = "https://api.oilpriceapi.com/v1/prices/"
    fun getRetrofitClient() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getOilService(retrofit: Retrofit) : OilService {
        return retrofit.create(OilService::class.java)
    }
}