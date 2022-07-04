package com.example.domain.repository
import com.example.domain.model.CoinResponse
import com.example.domain.utils.RemoteErrorEmitter


interface CoinRepository {
    suspend fun getCoin(remoteErrorEmitter: RemoteErrorEmitter) : List<CoinResponse>?
}