package com.hasan.travelguide.presentation.tripplan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentTripplanBinding
import com.hasan.travelguide.presentation.tripplan.tabView.TripPlanTabAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [TripPlanFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TripPlanFragment : Fragment() {

    private lateinit var binding: FragmentTripplanBinding
    private lateinit var tabAdapter:TripPlanTabAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTripplanBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabAdapter = TripPlanTabAdapter(this@TripPlanFragment)
        binding.tripsViewPager.adapter=tabAdapter
        TabLayoutMediator(binding.tripTabLayout,binding.tripsViewPager) { tab, position ->
            binding.tripsViewPager.isUserInputEnabled = false
            when(position){
                0 -> {tab.setText(R.string.trips)
                tab.setIcon(R.drawable.brief_selector)}
                1 -> {tab.setText(R.string.bookmark)
                tab.setIcon(R.drawable.bookmark_selector)
                }

            }

        }.attach()

    }
}