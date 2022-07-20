package com.example.ca_coin_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ca_coin_list.databinding.ItemCoinBinding
import com.example.ca_coin_list.model.PresentationCoin

class CoinListAdapter(private val list: List<PresentationCoin>): RecyclerView.Adapter<CoinListAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(private val binding: ItemCoinBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(presentationCoin: PresentationCoin) {
            binding.item = presentationCoin
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder =
        CoinViewHolder(ItemCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}