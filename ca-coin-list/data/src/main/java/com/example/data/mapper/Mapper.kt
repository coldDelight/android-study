package com.example.data.mapper


// Mapper 추상화 or 확장 함수 (코루틴 )
// 리스트 X -> 그냥 ㅊ
//object Mapper {
//    fun mapperCoin(response: List<CoinResponse>?) : List<com.example.domain.model.CoinResponse>? {
//        return response?.toDomain()
//    }
//
//    private fun List<CoinResponse>.toDomain() : List<com.example.domain.model.CoinResponse> {
//        return this.filter {
//            it.type=="coin"
//        }.map {
//            com.example.domain.model.CoinResponse(
//                it.id,
//                it.name,
//                it.symbol,
//                it.url,
//                it.rank,
//                it.is_new,
//                it.is_active,
//                it.type,
//            )
//        }
//    }
//}
