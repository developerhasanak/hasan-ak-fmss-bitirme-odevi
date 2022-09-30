package com.hasan.travelguide.presentation.home.deals

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {

    private lateinit var fragment: Fragment

    override fun getItemCount():Int = 4

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{fragment = AllFragment()}
            1->{fragment = FilgtsFragment()}
            2->{fragment = HotelsFragment()}
            3->{fragment = TransportationsFragment()}
        }
        return fragment
    }
}