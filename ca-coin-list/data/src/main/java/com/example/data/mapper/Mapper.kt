package com.example.data.mapper

import com.example.data.remote.model.CoinResponse
import com.google.gson.annotations.SerializedName


object Mapper {
    fun mapperCoin(response: List<CoinResponse>?) : List<com.example.domain.model.CoinResponse>? {
        return response?.toDomain()
    }

    private fun List<CoinResponse>.toDomain() : List<com.example.domain.model.CoinResponse> {
        return this.map {
            com.example.domain.model.CoinResponse(
                it.id,
                it.name,
                it.symbol,
                it.url,
                it.rank,
                it.is_new,
                it.is_active,
                it.type,
            )
        }
    }
}
