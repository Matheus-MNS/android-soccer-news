package com.example.soccernews.feature.favorites.data

import com.example.soccernews.common.data.local.NewsDao
import com.example.soccernews.feature.favorites.data.local.FavoritesNewsLocalDataSource
import com.example.soccernews.feature.favorites.domain.FavoritesNewsRepository
import com.example.soccernews.feature.news.domain.model.NewsModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class FavoritesNewsRepositoryImpl(
    private val favoritesNewsLocalDataSource: FavoritesNewsLocalDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) :
    FavoritesNewsRepository {
    override fun getFavoriteNews(): Flow<List<NewsModel>> =
        favoritesNewsLocalDataSource.getFavoriteNews().flowOn(dispatcher)
}