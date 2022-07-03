package com.example.soccernews.feature.news.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soccernews.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private val binding by lazy { FragmentFavoritesBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}