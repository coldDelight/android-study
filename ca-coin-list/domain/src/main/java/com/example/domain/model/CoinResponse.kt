package com.example.domain.model

data class DomainCoin(
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val id: String
)

