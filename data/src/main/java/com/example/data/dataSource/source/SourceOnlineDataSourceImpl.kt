package com.example.data.dataSource.source

import com.example.data.contract.datasource.newsSource.NewsSourceOnlineDataSource
import com.example.data.executeApi
import com.example.newsappxml.api.WebServices
import com.example.newsappxml.model.newsResponce.Article
import com.example.newsappxml.model.sourceResponnce.Source
import javax.inject.Inject

class SourceOnlineDataSourceImpl @Inject constructor(private val webServices: WebServices):NewsSourceOnlineDataSource {

    override suspend fun getNewsSource(): List<Source>? {
        val responce= executeApi { webServices.getNewsSource() }
        return responce.sources?.filterNotNull()?.map {
            it.toSource()
        }
    }
}

