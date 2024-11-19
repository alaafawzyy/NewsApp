package com.example.data.contract.datasource.newsSource

import com.example.newsappxml.model.sourceResponnce.Source
interface NewsSourceOnlineDataSource {
    suspend fun getNewsSource():List<Source>?
}