package com.hasan.travelguide.presentation.home.deals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentAllBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AllFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllFragment : Fragment() {

    private lateinit var binding: FragmentAllBinding
    private lateinit var itemAdapter: TabImageRecyclerAdapter

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

        //In the recycler view, the horizontal placement of the items is defined.
        binding.imageRecyclerVieew.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val image = arrayListOf(
            R.drawable.example,
            R.drawable.example2,
            R.drawable.example3
        )//bu kısım test için kaldırılacak
        //connects with recyclerview adapter
        itemAdapter = TabImageRecyclerAdapter(image)
        binding.imageRecyclerVieew.adapter = itemAdapter
    }
}