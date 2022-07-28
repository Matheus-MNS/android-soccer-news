package com.example.soccernews.feature.news.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class NewsModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val descriptor: String,
    val image: String,
    val link: String,
    var favorite: Boolean = false
) : Parcelable
