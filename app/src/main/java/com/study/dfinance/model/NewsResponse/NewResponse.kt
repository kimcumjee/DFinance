package com.stock.d_finance.model.NewsResponse

data class NewResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)