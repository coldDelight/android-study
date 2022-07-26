package com.example.domain.repository

import com.example.domain.model.DomainCoinDetailResponse

interface CoinDetailRepository {
    suspend fun getCoinDetail() : DomainCoinDetailResponse
}