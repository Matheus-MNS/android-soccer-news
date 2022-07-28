package com.example.soccernews.feature.news.presentation.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.soccernews.R
import com.example.soccernews.common.utils.AdapterItemWithParameterClickListener
import com.example.soccernews.common.utils.DefaultDiffCallback
import com.example.soccernews.databinding.NewsItemBinding
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.squareup.picasso.Picasso

class NewsAdapter : ListAdapter<NewsModel, NewsAdapter.ViewHolder>(
    DefaultDiffCallback<NewsModel>()
) {

    var favoriteClickListener: AdapterItemWithParameterClickListener<NewsModel> = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        NewsItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(newsItem: NewsModel) {

            with(binding) {
                thumbnailTextView.text = newsItem.title
                descriptionTextView.text = newsItem.descriptor
                openLinkButton.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(newsItem.link)
                    itemView.context.startActivity(intent)
                }
                Picasso.with(itemView.context)
                    .load(newsItem.image)
                    .fit()
                    .into(thumbnailImageView)

                shareImageView.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT, newsItem.link)
                    itemView.context.startActivity(Intent.createChooser(intent, "share"))
                }
                favoritesImageView.setOnClickListener {
                    newsItem.favorite = !newsItem.favorite
                    favoriteClickListener(newsItem)
                }
                val favoriteColor =
                    if (newsItem.favorite) R.color.favorite_active else R.color.favorite_inactive
                favoritesImageView.setColorFilter(
                    itemView.context.getColor(favoriteColor)
                )

            }
        }
    }
}
