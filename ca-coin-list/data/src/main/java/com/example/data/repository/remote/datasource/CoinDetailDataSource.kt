package com.example.data.repository.remote.datasource

import com.example.data.remote.model.CoinDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinDetailDataSource {

    @GET("/v1/coins/{coin_id}")
    suspend fun getCoinDetail(
        @Path("coin_id")
        id:String
    ): CoinDetailResponse
}