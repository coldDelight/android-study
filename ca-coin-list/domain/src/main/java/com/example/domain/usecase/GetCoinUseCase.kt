package com.example.domain.usecase

import javax.inject.Inject
import com.example.domain.repository.CoinRepository
import com.example.domain.utils.RemoteErrorEmitter

class GetCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    suspend fun execute(remoteErrorEmitter: RemoteErrorEmitter) =
        coinRepository.getCoin(remoteErrorEmitter)
}