package com.example.soccernews.feature.favorites.di

import com.example.soccernews.feature.favorites.data.FavoritesNewsRepositoryImpl
import com.example.soccernews.feature.favorites.data.local.FavoritesNewsLocalDataSource
import com.example.soccernews.feature.favorites.domain.use_case.FavoritesNewsUseCase
import com.example.soccernews.feature.favorites.presentantion.FavoriteNewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoritesModule = module {

    viewModel {
        FavoriteNewsViewModel(
            FavoritesNewsUseCase(
                repository = FavoritesNewsRepositoryImpl(
                    favoritesNewsLocalDataSource = FavoritesNewsLocalDataSource(
                        newsDao = get()
                    )
                )
            )
        )
    }
}