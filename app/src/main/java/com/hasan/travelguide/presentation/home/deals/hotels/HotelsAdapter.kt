package com.hasan.travelguide.presentation.home.deals.hotels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.HomeDealsAllItemBinding
import com.hasan.travelguide.domain.model.remotemodel.Image
import com.hasan.travelguide.utils.downloadFromUrl

class HotelsAdapter(var images: List<Image>):RecyclerView.Adapter<HotelsAdapter.HotelsViewModel>() {
    class HotelsViewModel(val binding: HomeDealsAllItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewModel {
        val binding = HomeDealsAllItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return HotelsViewModel(binding)
    }

    override fun onBindViewHolder(holder: HotelsViewModel, position: Int) {
         holder.binding.homeDealsItemView.downloadFromUrl(images[position].url)
    }

    override fun getItemCount(): Int {
        return  images.size
    }

}