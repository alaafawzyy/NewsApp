package com.example.newsxml.newsSource.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.repository.NewsRepository
import com.example.domain.repository.NewsSourceRepository
import com.example.domain.useCase.NewsUseCase
import com.example.domain.useCase.SourceUseCase
import com.example.newsappxml.model.newsResponce.Article
import com.example.newsappxml.model.sourceResponnce.Source
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(private val sourceuseCase: SourceUseCase,
                                          private val newsuseCase: NewsUseCase
):ViewModel() {
    val isLoadingLivedata=MutableLiveData<Boolean>()
    val message=MutableLiveData<ViewMessage>()
    val sourceLiveData=MutableLiveData<List<Source>?>()
    val newsLiveData=MutableLiveData<List<Article?>?>()




    fun getNewsSources(){
        isLoadingLivedata.value = true
        viewModelScope.launch(Dispatchers.IO) {
           sourceuseCase.invoke().collect{
                when(it){
                    is Resource.Success ->{
                        val result = it.data
                        sourceLiveData.postValue(result)
                    }
                    else -> {

                    }}}}}

        fun loadNews(id:String) {
            viewModelScope.launch {
                newsuseCase.invoke(id).collect {
                    when (it) {
                        is Resource.Success -> {
                            val result = it.data
                            newsLiveData.value = result
                        }

                        else -> {

                        }
                    }
                }
            }}}


