package com.stock.d_finance.Service

import com.stock.d_finance.model.NewsResponse.NewResponse
import com.stock.d_finance.model.OilResponse.OilResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewService {
    @GET("/v2/top-headlines?")
    suspend fun getNewsData(
        @Query("country")country : String,
        @Query("category")category : String,
        @Query("apiKey") apiKey : String,
    ): Response<NewResponse>
}