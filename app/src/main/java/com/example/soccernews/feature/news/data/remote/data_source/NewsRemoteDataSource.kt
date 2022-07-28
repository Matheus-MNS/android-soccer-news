package com.example.soccernews.feature.news.data.remote.data_source

import com.example.soccernews.feature.news.data.remote.model.NewsResponse
import com.example.soccernews.feature.news.data.remote.service.NewsService
import com.example.soccernews.feature.news.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRemoteDataSource(private val service: NewsService) {
    fun getNews(): Flow<List<NewsModel>> = flow {
        emit(service.getNews().toDomain())
    }

    private fun List<NewsResponse>.toDomain(): List<NewsModel> =
        this.map {
            NewsModel(
                id = it.id ?: 0,
                title = it.title.orEmpty(),
                descriptor = it.descriptor.orEmpty(),
                image = it.image.orEmpty(),
                link = it.link.orEmpty(),
            )
        }
}