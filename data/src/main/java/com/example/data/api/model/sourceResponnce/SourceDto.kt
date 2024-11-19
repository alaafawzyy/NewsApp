package com.example.newsappxml.model.sourceResponnce

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class SourceDto(
    val category: String?,
    val country: String?,
    val description: String?,
    val id: String?,
    val language: String?,
    val name: String?,
    val url: String?
){
    fun toSource():Source{
         return Source(category, country, description, id, language, name, url)
    }
}