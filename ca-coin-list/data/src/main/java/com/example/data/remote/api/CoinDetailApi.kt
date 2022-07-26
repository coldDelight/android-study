package com.example.data.remote.api

import com.example.data.remote.model.CoinDetailResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoinDetailApi {
    @GET("/v1/coins/bit-bitcoin")
    suspend fun getCoinDetail() : Response<CoinDetailResponse>
}