package com.example.soccernews.feature.news.data.remote.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val descriptor: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("url")
    val link: String?,
)