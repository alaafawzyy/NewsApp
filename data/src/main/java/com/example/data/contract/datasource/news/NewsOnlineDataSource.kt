package com.example.data.contract.datasource.news

import com.example.newsappxml.model.newsResponce.Article
import com.example.newsappxml.model.newsResponce.ArticleDto

interface NewsOnlineDataSource {
    suspend fun getNews(sourceId:String):List<Article>?
}