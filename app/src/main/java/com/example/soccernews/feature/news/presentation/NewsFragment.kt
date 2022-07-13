package com.example.soccernews.feature.news.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.soccernews.databinding.FragmentNewsBinding
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.presentation.adapter.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsFragment : Fragment() {

    private val binding by lazy { FragmentNewsBinding.inflate(layoutInflater) }
    private val viewModel: NewsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleObserver()
    }

    private fun handleObserver() {
        viewModel.newsList.observe(
            viewLifecycleOwner, Observer(
                ::handleRecyclerView
            )
        )
    }


    private fun handleRecyclerView(list: List<NewsModel>) {
        val newsAdapter = NewsAdapter(list)
        binding.newsRecyclerView.adapter = newsAdapter
    }

}