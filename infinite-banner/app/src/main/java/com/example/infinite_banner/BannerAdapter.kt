package com.example.infinite_banner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class BannerAdapter(var list: MutableList<Int>) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewBanner = itemView.findViewById<ImageView>(R.id.imageView_banner)

        fun onBind(res: Int) {
            imageViewBanner.setImageResource(res)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}