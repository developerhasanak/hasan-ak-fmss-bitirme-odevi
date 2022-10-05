package com.hasan.travelguide.presentation.tripplan.tabView

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TripPlanTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private lateinit var fragment: Fragment

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                fragment = TripsFragment()
            }
            1 -> {
                fragment = BookMarkFragment()
            }
        }
        return fragment
    }
}