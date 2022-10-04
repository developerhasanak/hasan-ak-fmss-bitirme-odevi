package com.hasan.travelguide.presentation.search.nearbyattractions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.NearbyAttractionsItemBinding

class NearbyAttractionsRecyclerAdapter(val imageList: List<Int>): RecyclerView.Adapter<NearbyAttractionsRecyclerAdapter.NearbyAttractionsViewHolder>() {
    class NearbyAttractionsViewHolder(val binding: NearbyAttractionsItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyAttractionsViewHolder {
        val binding = NearbyAttractionsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NearbyAttractionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NearbyAttractionsViewHolder, position: Int) {
        holder.binding.nearybyAttractionsItemImage.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}