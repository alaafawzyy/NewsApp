package com.example.newsappxml.model.newsResponce

import android.os.Parcelable
import com.example.newsappxml.model.sourceResponnce.SourceDto
import kotlinx.parcelize.Parcelize


data class ArticleDto(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceDto?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) {
    fun toArticle():Article{
        return Article(author,content,description,publishedAt, source?.toSource(),title,url,urlToImage)
    }

}