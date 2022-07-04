package com.example.data.remote.api

import com.example.data.remote.model.CoinResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins() : Response<List<CoinResponse>>
}