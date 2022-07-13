package com.example.soccernews.feature.news.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.domain.use_case.GetNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class NewsViewModel(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {

    val newsList: MutableLiveData<List<NewsModel>> by lazy {
        MutableLiveData<List<NewsModel>>()
    }


    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            getNewsUseCase()
                .flowOn(Dispatchers.IO)
                .catch { throw it  }
                .collect { handleSuccess(it) }
        }
    }

    private fun handleSuccess(news: List<NewsModel>) {
        this.newsList.value = news
    }
}