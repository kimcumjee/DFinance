package com.stock.d_finance.Service

import com.stock.d_finance.model.OilResponse.OilResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header


interface OilService {
    @GET("latest")
    suspend fun getOilPrice(
        @Header("Authorization") type:String
    ): Response<OilResponse>
}