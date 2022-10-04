package com.hasan.travelguide.presentation.search.topdestinations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.TopDestinationsItemBinding

class TopDestinationsRecyclerViewAdapter(val imageList: List<Int>):RecyclerView.Adapter<TopDestinationsRecyclerViewAdapter.TopDestinationsRecyclerViewHolder>() {
    class TopDestinationsRecyclerViewHolder(val binding: TopDestinationsItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopDestinationsRecyclerViewHolder {
        val binding = TopDestinationsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TopDestinationsRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopDestinationsRecyclerViewHolder, position: Int) {
        holder.binding.topDestinationsImageItem.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
       return imageList.size
    }
}