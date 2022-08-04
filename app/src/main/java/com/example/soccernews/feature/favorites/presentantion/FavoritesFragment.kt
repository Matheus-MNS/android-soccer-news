package com.example.soccernews.feature.favorites.presentantion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soccernews.databinding.FragmentFavoritesBinding
import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.presentation.adapter.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : Fragment() {

    private val binding by lazy { FragmentFavoritesBinding.inflate(layoutInflater) }
    private val viewModel: FavoriteNewsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observerState()
    }

    private fun observerState() {
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is FavoriteNewsViewState.FavoriteList ->
                    handleRecyclerView(state.favoriteNewsList)
            }
        }
    }

    private fun handleRecyclerView(list: List<NewsModel>) {
        val newsAdapter = NewsAdapter()
        newsAdapter.submitList(list)
        binding.favoriteRecyclerView.adapter = newsAdapter
    }
}