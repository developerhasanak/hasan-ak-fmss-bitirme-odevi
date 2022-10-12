package com.hasan.travelguide.presentation.search.topdestinations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.TopDestinationsItemBinding
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.domain.model.remotemodel.Image
import com.hasan.travelguide.utils.downloadFromUrl

class TopDestinationsRecyclerViewAdapter(val imageList: List<Image>):RecyclerView.Adapter<TopDestinationsRecyclerViewAdapter.TopDestinationsRecyclerViewHolder>() {
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
        holder.binding.topDestinationsImageItem.downloadFromUrl(imageList[position].url)

    }

    override fun getItemCount(): Int {
       return imageList.size
    }
}