package com.example.data.dataSource.source

import com.example.data.contract.datasource.newsSource.NewsSourceOnlineDataSource
import com.example.newsappxml.api.WebServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SourceOnlineDataSourceModulue{
    @Provides
    fun provideSourceOnlineDataSourceModulue(webServices: WebServices):NewsSourceOnlineDataSource{
               return SourceOnlineDataSourceImpl(webServices )
    }
}