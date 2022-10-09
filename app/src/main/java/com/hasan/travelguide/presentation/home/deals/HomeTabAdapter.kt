package com.hasan.travelguide.presentation.home.deals

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hasan.travelguide.presentation.home.deals.all.AllFragment
import javax.inject.Inject


/**
 *
 * This class takes axiom between fragments when tab items are clicked.
 *
 * @constructor
 *
 *
 * @param fragment ,a property of the class
 */

class HomeTabAdapter @Inject constructor (
    fragment: Fragment):FragmentStateAdapter(fragment) {

    private lateinit var fragment: Fragment

    override fun getItemCount():Int = 4

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{fragment = AllFragment() }
            1->{fragment = FilgtsFragment()}
            2->{fragment = HotelsFragment()}
            3->{fragment = TransportationsFragment()}
        }
        return fragment
    }
}