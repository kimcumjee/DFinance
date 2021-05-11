package com.study.dfinance.model.newsResponse



data class NewResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)