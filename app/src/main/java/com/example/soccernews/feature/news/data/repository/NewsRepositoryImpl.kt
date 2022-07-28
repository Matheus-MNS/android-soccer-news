package com.example.soccernews.feature.news.data.repository

import com.example.soccernews.feature.news.data.local.NewsLocalDataSource
import com.example.soccernews.feature.news.data.remote.data_source.NewsRemoteDataSource
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : NewsRepository {
    override fun getNews(): Flow<List<NewsModel>> =
        newsRemoteDataSource.getNews().flowOn(dispatcher)

    override fun insertNews(newsModel: NewsModel): Flow<Unit> =
        newsLocalDataSource.insertFavoriteNews(newsModel).flowOn(dispatcher)
}