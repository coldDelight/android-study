package com.example.data.repository.remote.datasource

import com.example.data.remote.model.CoinResponse
import com.example.domain.utils.RemoteErrorEmitter


interface CoinDataSource {
    suspend fun getCoin(remoteErrorEmitter: RemoteErrorEmitter) : List<CoinResponse>?
}