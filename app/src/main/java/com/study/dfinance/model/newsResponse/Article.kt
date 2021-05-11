package com.study.dfinance.model.newsResponse

data class Article(
    val author: Any,
    val content: Any,
    val description: Any,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: Any
)