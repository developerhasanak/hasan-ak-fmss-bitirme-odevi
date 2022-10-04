package com.hasan.travelguide.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentSearchBinding
import com.hasan.travelguide.presentation.search.nearbyattractions.NearbyAttractionsRecyclerAdapter
import com.hasan.travelguide.presentation.search.topdestinations.TopDestinationsRecyclerViewAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var topItemADApter:TopDestinationsRecyclerViewAdapter
    private lateinit var nearbyItemAdapter:NearbyAttractionsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //In the recycler view, the horizontal placement of the items is defined.
        binding.topDestinationsRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val image = arrayListOf(
            R.drawable.example4,
            R.drawable.example5,   //bu kısım test için kaldırılacak
            R.drawable.example6
        )
        //connects with recyclerview adapter
        topItemADApter = TopDestinationsRecyclerViewAdapter(image)
        binding.topDestinationsRecyclerView.adapter = topItemADApter

        binding.nearybyAttractionsRecyclerView.layoutManager = LinearLayoutManager(context)
        val image2 = arrayListOf(
            R.drawable.example8,
            R.drawable.example,   //bu kısım test için kaldırılacak
            R.drawable.example2
        )
        nearbyItemAdapter = NearbyAttractionsRecyclerAdapter(image2)
        binding.nearybyAttractionsRecyclerView.adapter = nearbyItemAdapter

    }
}