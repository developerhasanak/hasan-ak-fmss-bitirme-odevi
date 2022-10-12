package com.hasan.travelguide.presentation.home.deals.transportations

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
import com.hasan.travelguide.databinding.FragmentTransportationsBinding
import com.hasan.travelguide.presentation.home.deals.hotels.HotelsAdapter
import com.hasan.travelguide.utils.Status


class TransportationsFragment : Fragment() {

    private lateinit var binding: FragmentTransportationsBinding
    private lateinit var adapter: TransportationAdapter
    private lateinit var viewModel: TransportationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentTransportationsBinding.inflate(inflater)
      return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[TransportationViewModel::class.java]
        viewModel.getTransportation()

        binding.imageRecyclerView4.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)

        observerLiveData()

    }
    private fun observerLiveData() {
        viewModel.transportationList.observe(viewLifecycleOwner, Observer { flight ->
            flight?.let {
                when(it.status){
                    Status.SUCCESS ->{
                        val urls = it.data?.filter { x -> x.category=="transportation" }?.flatMap{x->x.images!!}
                        urls?.let {

                            adapter = TransportationAdapter(it)
                            binding.imageRecyclerView4.adapter = adapter
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