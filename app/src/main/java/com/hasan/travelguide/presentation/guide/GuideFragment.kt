package com.hasan.travelguide.presentation.guide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.FragmentGuideBinding
import com.hasan.travelguide.presentation.guide.mightneedthese.MightNeedTheseRecyclerAdapter
import com.hasan.travelguide.presentation.search.topdestinations.TopDestinationsRecyclerViewAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [GuideFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GuideFragment : Fragment() {

    private lateinit var binding: FragmentGuideBinding
    private lateinit var itemAdapter  : MightNeedTheseRecyclerAdapter
    private lateinit var itemAdapter2 : TopDestinationsRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuideBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding.mightNeedTheseRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
      val image = arrayListOf(R.drawable.card1,R.drawable.card2,R.drawable.card3)
      itemAdapter = MightNeedTheseRecyclerAdapter(image)
      binding.mightNeedTheseRecyclerView.adapter = itemAdapter


    }

}