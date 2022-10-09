package com.hasan.travelguide.presentation.home.deals.all

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hasan.travelguide.databinding.HomeDealsAllItemBinding
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import javax.inject.Inject

class AllFragmentRecyclerAdapter @Inject constructor(
    var imageList: List<AllTravelListItem>
) : RecyclerView.Adapter<AllFragmentRecyclerAdapter.TabImageRecyclerViewHolder>() {

    var imgList = arrayListOf<String>()

    class TabImageRecyclerViewHolder(val binding: HomeDealsAllItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabImageRecyclerViewHolder {
        val binding =
            HomeDealsAllItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TabImageRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TabImageRecyclerViewHolder, position: Int) {
        holder.binding.homeDealsItemView.apply {

            try {
                imageList[position].images.forEach {
                    imgList.add(it.url)
                }

                val img = imgList[position]
                Glide.with(holder.itemView.context).load(img).into(holder.binding.homeDealsItemView)

            } catch (e: Exception) {
                Log.v("Glide Error", e.toString())
            }
        }

    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}

