package com.hasan.travelguide.presentation.home.deals.hotels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentHotelsBinding
import com.hasan.travelguide.presentation.home.deals.flights.FlightsFragmentRecyclerAdapter
import com.hasan.travelguide.utils.Status


class HotelsFragment : Fragment() {

    private lateinit var binding: FragmentHotelsBinding
    private lateinit var adapter: HotelsAdapter
    private lateinit var viewModel: HotelsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentHotelsBinding.inflate(inflater)
     return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[HotelsViewModel::class.java]
        viewModel.hotelListApi()

        binding.imageRecyclerView3.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

         observerLiveData()
    }

    private fun observerLiveData() {
        viewModel.hotelList.observe(viewLifecycleOwner, Observer { flight ->
            flight?.let {
                when(it.status){
                    Status.SUCCESS ->{
                        val urls = it.data?.filter { x -> x.category=="hotel" }?.flatMap{x->x.images!!}
                        urls?.let {

                            adapter = HotelsAdapter(it)
                            binding.imageRecyclerView3.adapter = adapter
                        }

                    }

                    Status.ERROR->{
                        Toast.makeText(requireContext(),it.message ?: "Error", Toast.LENGTH_LONG).show()
                    }

                    Status.LOADING->{

                    }
                }


            }

        })

    }

}