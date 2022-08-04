package com.example.soccernews.feature.news.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.soccernews.R
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

        observeAction()
        observeState()
        swipeRefresh()
    }

    private fun observeAction() {
        viewModel.viewAction.observe(viewLifecycleOwner) { action ->
            if (action is NewsViewAction.ShowToast) {
                Toast.makeText(context, action.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeState() {
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is NewsViewState.Success ->
                    handleRecyclerView(state.newsList)
                is NewsViewState.Error ->
                    handleError(state.message)
            }
        }
    }


    private fun handleRecyclerView(list: List<NewsModel>) {
        val newsAdapter = NewsAdapter()
        newsAdapter.submitList(list)
        binding.newsRecyclerView.adapter = newsAdapter
        newsAdapter.favoriteClickListener = {
            viewModel.onFavoriteButtonClicked(it)
        }
    }

    private fun handleError(errorCode: String?) {
        Toast.makeText(context, errorCode, Toast.LENGTH_LONG).show()
    }

    private fun swipeRefresh() {
        with(binding) {
            newsSwipeRefresh.setColorSchemeResources(R.color.purple_500)
            newsSwipeRefresh.setOnRefreshListener {
                viewModel.getNews()
                newsSwipeRefresh.isRefreshing = false
            }
        }
    }
}