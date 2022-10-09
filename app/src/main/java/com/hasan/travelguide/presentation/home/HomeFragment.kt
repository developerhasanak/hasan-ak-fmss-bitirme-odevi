package com.hasan.travelguide.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentHomeBinding
import com.hasan.travelguide.presentation.home.deals.HomeTabAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var tabAdapter: HomeTabAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabAdapterconnection()
    }

    /**
     *This method connects homeViewpager2 with tab adapter and assigns text for selected tab items
     *
     */
    private fun tabAdapterconnection() {
        tabAdapter = HomeTabAdapter(this@HomeFragment)
        binding.homeViewPager2.adapter = tabAdapter
        TabLayoutMediator(binding.homeTabLayout, binding.homeViewPager2) { tab, position ->
            binding.homeViewPager2.isUserInputEnabled = false
            when (position) {
                0 -> {
                    tab.setText(R.string.all)
                }
                1 -> {
                    tab.setText(R.string.filgts)
                }
                2 -> {
                    tab.setText(R.string.hotels)
                }
                3 -> {
                    tab.setText(R.string.transportations)
                }
            }
        }.attach()
    }
}