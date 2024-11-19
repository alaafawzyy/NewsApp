package com.example.domain.repository

import com.example.domain.common.Resource
import com.example.newsappxml.model.newsResponce.Article
import com.example.newsappxml.model.sourceResponnce.Source
import kotlinx.coroutines.flow.Flow

interface NewsSourceRepository {
    suspend fun getNewsSource(): Flow<Resource<List<Source>?>>
}