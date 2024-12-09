package com.example.domain.useCase

import com.example.domain.common.Resource
import com.example.domain.repository.NewsSourceRepository
import com.example.newsappxml.model.sourceResponnce.Source
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SourceUseCase @Inject constructor(private val newsSourceRepository: NewsSourceRepository) {
    suspend fun invoke(): Flow<Resource<List<Source>?>> {
        return newsSourceRepository.getNewsSource()
    }

}