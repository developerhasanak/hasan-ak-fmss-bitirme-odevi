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

) : Fragment() {

    private lateinit var binding: FragmentAllBinding
    private lateinit var viewModel: AllfragmentViewModel
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

        viewModel = ViewModelProvider(requireActivity()).get(AllfragmentViewModel::class.java)
        binding.imageRecyclerVieew.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        viewModel.getAllItem()
        viewModel.allList.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    val list = it.data
                    list?.let {
                        allFragmentAdapter = AllFragmentRecyclerAdapter(list)
                        binding.imageRecyclerVieew.adapter = allFragmentAdapter
                    }
                }

                Status.ERROR -> {

                }

                Status.LOADING -> {

                }
            }
        })
    }
}