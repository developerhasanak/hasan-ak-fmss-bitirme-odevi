package com.hasan.travelguide.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentSearchBinding
import com.hasan.travelguide.presentation.home.deals.all.AllFragmentRecyclerAdapter
import com.hasan.travelguide.presentation.search.nearbyattractions.NearbyAttractionsRecyclerAdapter
import com.hasan.travelguide.presentation.search.topdestinations.TopDestinationsRecyclerViewAdapter
import com.hasan.travelguide.utils.Status
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var topItemAdapter:TopDestinationsRecyclerViewAdapter
    private lateinit var nearbyItemAdapter:NearbyAttractionsRecyclerAdapter
    private lateinit var viewNodel: SearchFragmentViewNodel

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

        viewNodel = ViewModelProvider(requireActivity())[SearchFragmentViewNodel::class.java]
        viewNodel.topDestinatiosApiData()



        //connects with recyclerview adapter


        binding.nearybyAttractionsRecyclerView.layoutManager = LinearLayoutManager(context)
        val image2 = arrayListOf(
            R.drawable.example8,
            R.drawable.trips_item_example,   //bu kısım test için kaldırılacak
            R.drawable.example2
        )
        //connects with recyclerview adapter
        nearbyItemAdapter = NearbyAttractionsRecyclerAdapter(image2)
        binding.nearybyAttractionsRecyclerView.adapter = nearbyItemAdapter

        topObservable()

    }

    private fun topObservable(){
        viewNodel.topDestinatiosList.observe(viewLifecycleOwner, Observer { allTravel->
            allTravel?.let {
                when (it.status) {
                    Status.SUCCESS -> {
                        val urls = it.data?.filter { x->x.category=="topdestination"}
                        urls?.let {
                             val img= it.flatMap { x -> x.images!!  }

                            topItemAdapter = TopDestinationsRecyclerViewAdapter(img)
                            binding.topDestinationsRecyclerView.adapter = topItemAdapter
                        }

                    }

                    Status.ERROR -> {
                        Toast.makeText(requireContext(), it.message ?: "Error", Toast.LENGTH_LONG)
                            .show()
                    }

                    Status.LOADING -> {

                    }
                }


            }

        })

    }
}