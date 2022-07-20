package com.example.domain.repository
import com.example.domain.model.DomainCoin
import com.example.domain.utils.RemoteErrorEmitter


interface CoinRepository {
    suspend fun getCoin() : List<DomainCoin>
}