package com.example.data.repository

import com.example.data.remote.model.toDomainCoin
import com.example.data.repository.remote.datasource.CoinDataSource
import com.example.domain.model.DomainCoin
import com.example.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinDataSource
) : CoinRepository {

    override suspend fun getCoin(): List<DomainCoin> {
        return api.getCoin().filter { it.type == "coin" }.map { it.toDomainCoin() }
    }
}