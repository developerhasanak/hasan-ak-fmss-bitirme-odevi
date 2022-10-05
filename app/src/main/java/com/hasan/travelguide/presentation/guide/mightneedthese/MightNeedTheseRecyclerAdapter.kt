package com.hasan.travelguide.presentation.guide.mightneedthese

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.databinding.MightNeedTheseItemBinding

class MightNeedTheseRecyclerAdapter(val imageList: List<Int>): RecyclerView.Adapter<MightNeedTheseRecyclerAdapter.MightNeedTheseViewHolder>() {
    class MightNeedTheseViewHolder(val binding: MightNeedTheseItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MightNeedTheseViewHolder {
        val binding = MightNeedTheseItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MightNeedTheseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MightNeedTheseViewHolder, position: Int) {
        holder.binding.mightNeedTheseItemView.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}