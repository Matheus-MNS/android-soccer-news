package com.example.soccernews.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.soccernews.R
import com.example.soccernews.databinding.FragmentContainerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContainerFragment : Fragment() {

    private val binding by lazy { FragmentContainerBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val naviView: BottomNavigationView = binding.navView
        val navController = requireActivity().findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_news, R.id.navigation_favorites
            )
        )
        (requireActivity() as AppCompatActivity).setupActionBarWithNavController(
            navController = navController,
            configuration = appBarConfiguration
        )
        naviView.setupWithNavController(navController)


    }
}