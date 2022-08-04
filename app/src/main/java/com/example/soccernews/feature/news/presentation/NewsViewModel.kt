package com.example.soccernews.feature.news.presentation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccernews.R
import com.example.soccernews.common.utils.SingleLiveEvent
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.domain.use_case.GetNewsUseCase
import com.example.soccernews.feature.news.domain.use_case.SaveNewsOnFavoritesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val saveNewsOnFavoritesUseCase: SaveNewsOnFavoritesUseCase,
    private val application: Application
) : ViewModel() {

    val viewState = MutableLiveData<NewsViewState>()
    val viewAction = SingleLiveEvent<NewsViewAction>()

    init {
        getNews()
    }

    fun getNews() {
        viewModelScope.launch {
            getNewsUseCase()
                .catch {
                    viewState.value = NewsViewState.Error(it.message)
                }
                .collect {
                    viewState.value = NewsViewState.Success(it)
                }
        }
    }

    fun onFavoriteButtonClicked(news: NewsModel) {
        saveNewsOnFavorite(news)
    }

    private fun saveNewsOnFavorite(news: NewsModel) {
        viewModelScope.launch {
            saveNewsOnFavoritesUseCase(news)
                .catch {
                    viewAction.value =
                        NewsViewAction.ShowToast(application.getString(R.string.save_error))
                }
                .collect {
                    viewAction.value =
                        NewsViewAction.ShowToast(application.getString(R.string.save_success))
                }
        }
    }

}