package com.study.dfinance.model.OilResponse

data class Data(
    val code: String,
    val created_at: String,
    val currency: String,
    val formatted: String,
    val price: Double,
    val type: String
)