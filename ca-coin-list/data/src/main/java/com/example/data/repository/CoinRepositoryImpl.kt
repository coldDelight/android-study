package com.example.data.repository

import com.example.data.mapper.Mapper
import com.example.data.repository.remote.datasource.CoinDataSource
import com.example.domain.model.CoinResponse
import com.example.domain.repository.CoinRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinDataSource: CoinDataSource
) : CoinRepository {
    override suspend fun getCoin(
        remoteErrorEmitter: RemoteErrorEmitter,
    ): List<CoinResponse>? {
        return Mapper.mapperGithub(coinDataSource.getCoin(remoteErrorEmitter))
    }
}