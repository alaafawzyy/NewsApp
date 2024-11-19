package com.example.data.dataSource.news

import com.example.data.contract.datasource.news.NewsOnlineDataSource
import com.example.data.executeApi
import com.example.newsappxml.api.WebServices
import com.example.newsappxml.model.newsResponce.Article
import javax.inject.Inject

class NewsOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices):NewsOnlineDataSource {

    override suspend fun getNews(sourceId: String): List<Article>? {
        val responce= executeApi { webServices.getNews(source =sourceId) }
        return responce.articles?.filterNotNull()?.map {
            it.toArticle()
        }
    }

}
