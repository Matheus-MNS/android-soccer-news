package com.example.soccernews.feature.news.data.repository

import com.example.soccernews.feature.news.data.remote.data_source.NewsRemoteDataSource
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsRemoteDataSource: NewsRemoteDataSource) : NewsRepository {
    override fun getNews(): Flow<List<NewsModel>> = newsRemoteDataSource.getNews()
}