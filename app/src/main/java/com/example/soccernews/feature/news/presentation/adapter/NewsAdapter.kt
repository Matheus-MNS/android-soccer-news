package com.example.soccernews.feature.news.presentation.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.soccernews.databinding.NewsItemBinding
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.squareup.picasso.Picasso
import java.net.URL
import kotlin.coroutines.coroutineContext

class NewsAdapter(private val list: List<NewsModel>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val binding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false

        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
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
            }
        }
    }

}
