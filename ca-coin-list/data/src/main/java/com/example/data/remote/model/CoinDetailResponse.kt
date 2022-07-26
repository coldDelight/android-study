package com.example.data.remote.model

import com.example.domain.model.DomainCoinDetailResponse
import com.example.domain.model.TeamResponse
import com.google.gson.annotations.SerializedName

data class CoinDetailResponse(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    @SerializedName("is_active")
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamResponse>
)
fun CoinDetailResponse.toDomainCoinDetailResponse(): DomainCoinDetailResponse = DomainCoinDetailResponse(
    coinId, name, description, symbol, rank,isActive, tags,team
)


