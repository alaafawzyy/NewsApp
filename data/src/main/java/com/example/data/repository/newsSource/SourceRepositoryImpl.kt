package com.example.data.repository.newsSource

import com.example.data.contract.datasource.newsSource.NewsSourceOnlineDataSource
import com.example.data.toFlow
import com.example.domain.common.Resource
import com.example.domain.repository.NewsSourceRepository
import com.example.newsappxml.model.sourceResponnce.Source
import java.util.concurrent.Flow
import javax.inject.Inject

class SourceRepositoryImpl @Inject constructor(private val sourceOnlineDataSource: NewsSourceOnlineDataSource):
    NewsSourceRepository {
    override suspend fun getNewsSource(): kotlinx.coroutines.flow.Flow<Resource<List<Source>?>> {
        return toFlow { sourceOnlineDataSource.getNewsSource() }
    }

}