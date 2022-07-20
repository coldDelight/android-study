package com.example.ca_coin_list.usecase


import com.example.ca_coin_list.model.PresentationCoin
import com.example.ca_coin_list.model.toPresentationCoin
import javax.inject.Inject
import com.example.domain.repository.CoinRepository
import retrofit2.HttpException
import com.example.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException


class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
    ) {
    operator fun invoke(): Flow<Resource<List<PresentationCoin>>> = flow {
        try {
            emit(Resource.Loading<List<PresentationCoin>>())
            val coins = coinRepository.getCoin().map { it.toPresentationCoin() }
            emit(Resource.Success<List<PresentationCoin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<PresentationCoin>>(e.localizedMessage ?: "알 수 없는 오류 입니다."))
        } catch (e: IOException) {
            emit(Resource.Error<List<PresentationCoin>>("서버와 연결 할 수 없습니다. 모바일 데이터나 Wi-Fi를 확인 해주세요."))
        }
    }
}