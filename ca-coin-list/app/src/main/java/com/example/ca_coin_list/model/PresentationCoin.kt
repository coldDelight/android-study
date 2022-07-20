package com.example.ca_coin_list.model

import com.example.domain.model.DomainCoin

data class PresentationCoin(
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val id: String
)

fun DomainCoin.toPresentationCoin(): PresentationCoin =
    PresentationCoin(
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank,
        symbol = symbol,
        id = id
    )




