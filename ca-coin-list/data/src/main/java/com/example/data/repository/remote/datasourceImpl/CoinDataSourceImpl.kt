package com.example.data.repository.remote.datasourceImpl

import com.example.data.remote.api.CoinApi
import com.example.data.repository.remote.datasource.CoinDataSource
import com.example.data.remote.model.CoinListResponse
import com.example.data.utils.base.BaseRepository
import com.example.domain.utils.RemoteErrorEmitter
import retrofit2.Retrofit


import javax.inject.Inject

class CoinDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
) :  CoinDataSource {
    override suspend fun getCoin(): List<CoinListResponse> {
        return retrofit.create(CoinDataSource::class.java).getCoin()
    }
}
//CoinDataSource