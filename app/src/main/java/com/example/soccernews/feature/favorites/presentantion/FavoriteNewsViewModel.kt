package com.example.soccernews.feature.favorites.presentantion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soccernews.feature.favorites.domain.use_case.FavoritesNewsUseCase
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.domain.use_case.SaveNewsOnFavoritesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class FavoriteNewsViewModel(
    private val favoritesUseCase: FavoritesNewsUseCase
) : ViewModel() {

    val newsFavorite: MutableLiveData<List<NewsModel>> by lazy {
        MutableLiveData<List<NewsModel>>()
    }

    init {
        getFavoriteNews()
    }

    private fun getFavoriteNews() {
        viewModelScope.launch {
            favoritesUseCase()
                .catch { }
                .collect { newsFavorite.value = it }
        }
    }
}