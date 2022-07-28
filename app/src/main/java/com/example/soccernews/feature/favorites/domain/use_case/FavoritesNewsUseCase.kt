package com.example.soccernews.feature.favorites.domain.use_case

import com.example.soccernews.common.data.local.NewsDao
import com.example.soccernews.feature.favorites.domain.FavoritesNewsRepository
import com.example.soccernews.feature.news.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

class FavoritesNewsUseCase(private val repository: FavoritesNewsRepository) {

    operator fun invoke(): Flow<List<NewsModel>> =
        repository.getFavoriteNews()

}