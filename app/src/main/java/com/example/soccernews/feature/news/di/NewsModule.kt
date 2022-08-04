package com.example.soccernews.feature.news.di

import com.example.soccernews.feature.news.data.local.NewsLocalDataSource
import com.example.soccernews.feature.news.data.remote.data_source.NewsRemoteDataSource
import com.example.soccernews.feature.news.data.remote.service.NewsService
import com.example.soccernews.feature.news.data.repository.NewsRepositoryImpl
import com.example.soccernews.feature.news.domain.repository.NewsRepository
import com.example.soccernews.feature.news.domain.use_case.GetNewsUseCase
import com.example.soccernews.feature.news.domain.use_case.SaveNewsOnFavoritesUseCase
import com.example.soccernews.feature.news.presentation.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val newsModule = module {
    viewModel {
        NewsViewModel(
            getNewsUseCase = GetNewsUseCase(
                repository = get()
            ),
            saveNewsOnFavoritesUseCase = SaveNewsOnFavoritesUseCase(
                repository = get()
            ),
            application = get()
        )
    }

    factory<NewsRepository> {
        NewsRepositoryImpl(
            newsRemoteDataSource = NewsRemoteDataSource(
                service = get<Retrofit>().create(NewsService::class.java)
            ),
            newsLocalDataSource = NewsLocalDataSource(
                newsDao = get()
            )
        )
    }
}