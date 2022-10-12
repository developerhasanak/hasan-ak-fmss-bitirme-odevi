package com.hasan.travelguide.presentation.home.deals.flights

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.HomeDealsAllItemBinding
import com.hasan.travelguide.domain.model.remotemodel.Image
import com.hasan.travelguide.utils.GlideApp
import com.hasan.travelguide.utils.downloadFromUrl


class FlightsFragmentRecyclerAdapter(var imageList: List<Image>): RecyclerView.Adapter<FlightsFragmentRecyclerAdapter.FlightsFragmentViewHolder>() {

    class FlightsFragmentViewHolder(val binding: HomeDealsAllItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightsFragmentViewHolder {
        val binding =
            HomeDealsAllItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlightsFragmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlightsFragmentViewHolder, position: Int) {
        try {
            //GlideApp.with(holder.itemView.context).load(imageList[position].url).into(holder.binding.homeDealsItemView)
            holder.binding.homeDealsItemView.downloadFromUrl(imageList[position].url)
        } catch (e:Exception){
            e.message
        }

    }

    override fun getItemCount(): Int {
        return  imageList.size
    }
}