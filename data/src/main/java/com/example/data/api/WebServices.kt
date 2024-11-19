package com.example.newsappxml.api

import com.example.newsappxml.model.newsResponce.NewsResponce
import com.example.newsappxml.model.sourceResponnce.SourcesResponce
import com.example.data.api.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

    @GET("v2/top-headlines/sources")
    suspend fun getNewsSource(
        @Query("apiKey") apikey:String= Constants.apikey,
    ):SourcesResponce

    @GET("v2/everything")
    suspend fun getNews(
        @Query("apiKey") apikey:String= Constants.apikey,
        @Query("sources")source:String,
    ):NewsResponce

    @GET("v2/everything")
    fun getNewsBySearch(
        @Query("apiKey") apikey:String= Constants.apikey,
        @Query("q")queue:String,
    ):Call<NewsResponce>
}