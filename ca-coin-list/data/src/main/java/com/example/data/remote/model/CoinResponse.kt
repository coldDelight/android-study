package com.example.data.remote.model

import com.google.gson.annotations.SerializedName
import com.example.domain.model.DomainCoin


data class CoinListResponse(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
fun CoinListResponse.toDomainCoin(): DomainCoin = DomainCoin(
    isActive, isNew, name, rank, symbol, id
)
