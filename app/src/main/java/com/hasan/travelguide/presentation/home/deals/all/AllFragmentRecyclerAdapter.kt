package com.hasan.travelguide.presentation.home.deals.all


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.HomeDealsAllItemBinding
import com.hasan.travelguide.domain.model.remotemodel.AllTravelListItem
import com.hasan.travelguide.domain.model.remotemodel.Image
import com.hasan.travelguide.utils.GlideApp
import com.hasan.travelguide.utils.downloadFromUrl
import javax.inject.Inject


class AllFragmentRecyclerAdapter @Inject constructor(
    var imageList: List<Image>

) : RecyclerView.Adapter<AllFragmentRecyclerAdapter.AllFragmentViewHolder>() {

    class AllFragmentViewHolder(val binding: HomeDealsAllItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllFragmentViewHolder {
        val binding =
            HomeDealsAllItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllFragmentViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AllFragmentViewHolder, position: Int) {

        try {
            //GlideApp.with(holder.itemView.context).load(imageList[position].url).into(holder.binding.homeDealsItemView)
            holder.binding.homeDealsItemView.downloadFromUrl(imageList[position].url)
        } catch (e:Exception){
             e.message
         }
    }
    override fun getItemCount(): Int {
        return imageList.size
    }
}

