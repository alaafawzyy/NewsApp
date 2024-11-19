package com.example.newsappxml.model.newsResponce

data class NewsResponce(
    val articles: List<ArticleDto?>?,
    val status: String?,
    val totalResults: Int?,

    )