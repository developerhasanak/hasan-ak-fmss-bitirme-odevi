package com.hasan.travelguide.presentation.home.deals.flights

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.travelguide.databinding.FragmentFlightsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FilgtsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FlightsFragment : Fragment() {

    private lateinit var binding: FragmentFlightsBinding
    private lateinit var viewModel: FlightsFragmentViewModel
    private lateinit var adapter: FlightsFragmentRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFlightsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[FlightsFragmentViewModel::class.java]
        viewModel.getDataFromApi()

        binding.imageRecyclerView2.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        observerLiveData()

    }

    private fun observerLiveData() {
        viewModel.allList.observe(viewLifecycleOwner, Observer { flight ->
            flight?.let {
                val url = it.flatMap { x -> x.images!! }
                adapter = FlightsFragmentRecyclerAdapter(url)
                binding.imageRecyclerView2.adapter = adapter

            }

        })

    }

}