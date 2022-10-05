package com.hasan.travelguide.presentation.tripplan.tabView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentTripsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TripsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TripsFragment : Fragment() {

    private lateinit var binding:FragmentTripsBinding
    private lateinit var itemAdapter:TripsTabItemRecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTripsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tripsRecyclerView.layoutManager = LinearLayoutManager(context)
        val image = arrayListOf(
            R.drawable.example,
            R.drawable.example2,
            R.drawable.example3
        )//bu kısım test için kaldırılacak
        itemAdapter = TripsTabItemRecyclerView(image)
        binding.tripsRecyclerView.adapter = itemAdapter


    }
}