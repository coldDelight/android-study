package com.example.data.repository

import com.example.data.remote.model.toDomainCoinDetailResponse
import com.example.data.repository.remote.datasource.CoinDetailDataSource
import com.example.domain.model.DomainCoinDetailResponse
import com.example.domain.repository.CoinDetailRepository
import javax.inject.Inject

class CoinDetailRepositoryImpl @Inject constructor(
    private val api: CoinDetailDataSource
) : CoinDetailRepository {
    override suspend fun getCoinDetail(id:String): DomainCoinDetailResponse {
        return api.getCoinDetail(id).toDomainCoinDetailResponse()
    }

}