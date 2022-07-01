package com.example.soccernews.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainer
import com.example.soccernews.R
import com.example.soccernews.databinding.FragmentContainerBinding

class ContainerFragment : Fragment() {

    private val binding by lazy { FragmentContainerBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}