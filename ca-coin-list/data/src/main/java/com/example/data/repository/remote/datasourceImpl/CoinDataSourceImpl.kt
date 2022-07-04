package com.example.data.repository.remote.datasourceImpl

import com.example.data.remote.api.CoinApi
import com.example.data.repository.remote.datasource.CoinDataSource
import com.example.data.remote.model.CoinResponse
import com.example.data.utils.base.BaseRepository
import com.example.domain.utils.RemoteErrorEmitter


import javax.inject.Inject

class CoinDataSourceImpl @Inject constructor(
    private val coinApi: CoinApi
) : BaseRepository(), CoinDataSource {
    override suspend fun getCoin(remoteErrorEmitter: RemoteErrorEmitter): List<CoinResponse>? {
        return safeApiCall(remoteErrorEmitter){coinApi.getCoins().body()}
    }
}