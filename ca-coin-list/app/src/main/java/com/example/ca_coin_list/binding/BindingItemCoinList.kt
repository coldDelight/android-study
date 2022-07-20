package com.example.ca_coin_list.binding

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.ca_coin_list.model.PresentationCoin
import com.example.ca_coin_list.R

@SuppressLint("SetTextI18n")
@BindingAdapter("setCoinListText")
fun bindSetCoinListText(tv: TextView, item: PresentationCoin?) {
    item ?: return

    if (item.isNew) {
        tv.text = "${item.rank}. ${item.name} (${item.symbol}) (${item.isNew})"
    }
    else {
        tv.text = "${item.rank}. ${item.name} (${item.symbol})"
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setCoinListIsActive")
fun bindSetCoinListIsActive(tv: TextView, item: PresentationCoin?) {
    item ?: return

    if (item.isActive) {
        tv.text = "Active"
        tv.setTextColor(ContextCompat.getColor(tv.context, R.color.teal_700))
    }
    else {
        tv.text = "Inactive"
        tv.setTextColor(ContextCompat.getColor(tv.context, R.color.purple_700))
    }
}