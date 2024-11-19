package com.example.data.repository.news

import com.example.data.contract.datasource.news.NewsOnlineDataSource
import com.example.data.toFlow
import com.example.domain.common.Resource
import com.example.domain.repository.NewsRepository
import com.example.newsappxml.model.newsResponce.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsOnlineDataSource: NewsOnlineDataSource): NewsRepository {
    override suspend fun getNews(sourceId: String): Flow<Resource<List<Article>?>> {
        return toFlow { newsOnlineDataSource.getNews(sourceId = sourceId) }
    }

}