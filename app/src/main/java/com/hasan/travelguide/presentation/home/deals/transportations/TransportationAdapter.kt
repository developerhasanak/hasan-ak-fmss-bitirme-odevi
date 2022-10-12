package com.hasan.travelguide.presentation.home.deals.transportations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.HomeDealsAllItemBinding
import com.hasan.travelguide.domain.model.remotemodel.Image
import com.hasan.travelguide.utils.downloadFromUrl

class TransportationAdapter(var images: List<Image>):RecyclerView.Adapter<TransportationAdapter.TransportationViewHolder>() {
    class TransportationViewHolder(val binding:HomeDealsAllItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransportationViewHolder {
        val binding = HomeDealsAllItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TransportationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransportationViewHolder, position: Int) {
        holder.binding.homeDealsItemView.downloadFromUrl(images[position].url)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}