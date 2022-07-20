package com.example.data.repository.remote.datasource

import com.example.data.remote.model.CoinListResponse
import retrofit2.http.GET

interface CoinDataSource {

    @GET("/v1/coins")
    suspend fun getCoin(): List<CoinListResponse>
}