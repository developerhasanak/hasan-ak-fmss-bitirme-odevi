package com.hasan.travelguide.presentation.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentGuideBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GuideFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuideBinding.inflate(inflater)
        return binding.root
    }
}