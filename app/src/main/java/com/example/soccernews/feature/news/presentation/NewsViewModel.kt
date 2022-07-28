package com.example.soccernews.feature.news.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.domain.use_case.GetNewsUseCase
import com.example.soccernews.feature.news.domain.use_case.SaveNewsOnFavoritesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val saveNewsOnFavoritesUseCase: SaveNewsOnFavoritesUseCase
) : ViewModel() {

    val newsList: MutableLiveData<List<NewsModel>> by lazy {
        MutableLiveData<List<NewsModel>>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val isSavedOnFavorites: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    init {
        getNews()
    }

    fun getNews() {
        viewModelScope.launch {
            getNewsUseCase()
                .catch {handleError(it) }
                .collect { handleSuccess(it) }
        }
    }

    private fun handleSuccess(news: List<NewsModel>) {
        newsList.value = news
    }

    private fun handleError(throwable: Throwable) {
        error.value = throwable.message
    }

    fun onFavoriteButtonClicked(news: NewsModel) {
        saveNewsOnFavorite(news)
    }

    private fun saveNewsOnFavorite(news: NewsModel) {
        viewModelScope.launch {
            saveNewsOnFavoritesUseCase(news)
                .catch { isSavedOnFavorites.value = false }
                .collect { isSavedOnFavorites.value = true }
        }
    }
}