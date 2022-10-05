package com.hasan.travelguide.presentation.guide.toppickarticles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.travelguide.R
import com.hasan.travelguide.databinding.GuideScreenCardsItemBinding

class TopPickArticlesRecyclerAdapter(val imageList:List<Int>):RecyclerView.Adapter<TopPickArticlesRecyclerAdapter.TopPickArticlesViewHolder>() {
    class TopPickArticlesViewHolder(val binding:GuideScreenCardsItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPickArticlesViewHolder {
        val binding = GuideScreenCardsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  TopPickArticlesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopPickArticlesViewHolder, position: Int) {
        holder.binding.cardImage.setImageResource(imageList.size)

    }

    override fun getItemCount(): Int {
        return  imageList.size

    }
}