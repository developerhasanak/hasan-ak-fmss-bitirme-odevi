package com.hasan.travelguide.presentation.home.deals.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.travelguide.databinding.FragmentAllBinding
import kotlinx.coroutines.*
import java.text.FieldPosition

/**
 * A simple [Fragment] subclass.
 * Use the [AllFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class AllFragment:Fragment() {

    private lateinit var binding: FragmentAllBinding
    private lateinit var viewModel: AllfragmentViewModel
    private lateinit var allFragmentAdapter:AllFragmentRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[AllfragmentViewModel::class.java]
        viewModel.getDataFromApi()

        binding.imageRecyclerVieew.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

         observerLiveData()

    }
    private fun observerLiveData() {
    viewModel.allList.observe(viewLifecycleOwner, Observer { allTravel->
        allTravel?.let {
                val url = it.flatMap {x-> x.images!! }
            allFragmentAdapter = AllFragmentRecyclerAdapter(url)
                binding.imageRecyclerVieew.adapter = allFragmentAdapter

        }

    })



    }


}