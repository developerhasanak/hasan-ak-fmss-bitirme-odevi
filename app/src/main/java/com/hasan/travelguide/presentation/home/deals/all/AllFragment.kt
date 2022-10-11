package com.hasan.travelguide.presentation.home.deals.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentAllBinding
import com.hasan.travelguide.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [AllFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class AllFragment @Inject constructor(

) : Fragment(R.layout.fragment_all) {

    private lateinit var binding: FragmentAllBinding

    private val viewModel: AllfragmentViewModel by viewModels()


    private lateinit var allFragmentAdapter: AllFragmentRecyclerAdapter

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

        viewModel.getDataFromApi()

        binding.imageRecyclerVieew.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

         observerLiveData()

    }
    private fun observerLiveData() {
    viewModel.allList.observe(viewLifecycleOwner, Observer { allTravel->
        allTravel?.let {
            when (it.status) {
                Status.SUCCESS -> {
                    val urls = it.data?.flatMap { x -> x.images!! }
                    urls?.let {

                        allFragmentAdapter = AllFragmentRecyclerAdapter(urls)
                        binding.imageRecyclerVieew.adapter = allFragmentAdapter
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