package com.hasan.travelguide.presentation.trip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentSearchBinding
import com.hasan.travelguide.databinding.FragmentTripBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TripFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TripFragment : Fragment() {

    private lateinit var binding: FragmentTripBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTripBinding.inflate(inflater)
        return binding.root
    }
}