package com.study.dfinance.service

import com.study.dfinance.model.newsResponse.NewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewService {
    @GET("/v2/top-headlines?")
    suspend fun getNewsData(
        @Query("country")country : String,
        @Query("category")category : String,
        @Query("apiKey") apiKey : String,
    ): Response<NewResponse>
}