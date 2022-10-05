package com.hasan.travelguide.presentation.home.deals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.HomeDealsAllItemBinding

class HomeTabImageRecyclerAdapter(val imageList:ArrayList<Int>):RecyclerView.Adapter<HomeTabImageRecyclerAdapter.TabImageRecyclerViewHolder>() {
    class TabImageRecyclerViewHolder(val binding: HomeDealsAllItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabImageRecyclerViewHolder {
        val binding = HomeDealsAllItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TabImageRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TabImageRecyclerViewHolder, position: Int) {
        holder.binding.homeDealsItemView.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return  imageList.size
    }
}