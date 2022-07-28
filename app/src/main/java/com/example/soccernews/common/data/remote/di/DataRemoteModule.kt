package com.example.soccernews.common.data.remote.di

import com.example.soccernews.BuildConfig
import com.example.soccernews.common.data.remote.WebServiceFactory.provideOkHttpClient
import com.example.soccernews.common.data.remote.WebServiceFactory.provideRetrofit
import org.koin.dsl.module

val dataRemoteModule = module {

    single {
        provideRetrofit(
            provideOkHttpClient(
                BuildConfig.DEBUG && BuildConfig.BUILD_TYPE == "debug"
            )
        )
    }
}