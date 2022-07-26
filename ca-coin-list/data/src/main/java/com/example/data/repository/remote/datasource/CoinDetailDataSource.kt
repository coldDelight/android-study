package com.example.data.repository.remote.datasource

import com.example.data.remote.model.CoinDetailResponse
import retrofit2.http.GET


interface CoinDetailDataSource {

    @GET("/v1/coins/btc/bitcoin")
    suspend fun getCoinDetail(): CoinDetailResponse
}