package com.hasan.travelguide.presentation.tripplan.tabView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.FragmentTripsItemBinding
import com.hasan.travelguide.databinding.FragmentTripsItemBindingImpl

class TripsTabItemRecyclerView(val imageList: List<Int>):RecyclerView.Adapter<TripsTabItemRecyclerView.TripsTabItemViewHolder>() {
    class TripsTabItemViewHolder(val binding: FragmentTripsItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripsTabItemViewHolder {
        val binding = FragmentTripsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TripsTabItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TripsTabItemViewHolder, position: Int) {
        holder.binding.tripsFragmentItemImage.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}