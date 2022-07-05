package com.example.ca_coin_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.CoinResponse
import com.example.ca_coin_list.databinding.ItemCoinBinding


class CoinAdapter : RecyclerView.Adapter<CoinViewHolder>() {

    private val items = mutableListOf<CoinResponse>()

    fun setItems(items: List<CoinResponse>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(
            ItemCoinBinding.inflate(layoutInflater)
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class CoinViewHolder(
    private val binding: ItemCoinBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repo: CoinResponse) {
        binding.name.text = repo.name
        binding.symbol.text = repo.symbol
    }
}