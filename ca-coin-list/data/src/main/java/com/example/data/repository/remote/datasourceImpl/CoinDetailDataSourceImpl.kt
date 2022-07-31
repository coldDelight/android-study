package com.example.data.repository.remote.datasourceImpl

import com.example.data.remote.model.CoinDetailResponse
import com.example.data.repository.remote.datasource.CoinDetailDataSource
import retrofit2.Retrofit
import javax.inject.Inject

class CoinDetailDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
) : CoinDetailDataSource {
    override suspend fun getCoinDetail(id:String): CoinDetailResponse {
        return retrofit.create(CoinDetailDataSource::class.java).getCoinDetail(id)
    }
}