package com.example.ca_coin_list.model

import com.example.domain.model.DomainCoinDetailResponse
import com.example.domain.model.TeamResponse


data class DetailPresentationCoin(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamResponse>
)

fun DomainCoinDetailResponse.toDetailPresentationCoin(): DetailPresentationCoin =
    DetailPresentationCoin(
        coinId  = coinId ,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags =tags,
        team = team
    )


