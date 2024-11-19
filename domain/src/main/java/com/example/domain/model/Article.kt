package com.example.newsappxml.model.newsResponce

import android.os.Parcelable
import com.example.newsappxml.model.sourceResponnce.Source
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
): Parcelable