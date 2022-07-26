package com.example.ca_coin_list.usecase

import com.example.ca_coin_list.model.DetailPresentationCoin
import com.example.ca_coin_list.model.toDetailPresentationCoin
import com.example.domain.Resource
import com.example.domain.repository.CoinDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(
    private val coinDetailRepository: CoinDetailRepository
) {
    operator fun invoke(): Flow<Resource<DetailPresentationCoin>> = flow {
        try {
            emit(Resource.Loading<DetailPresentationCoin>())
            val coinDetail = coinDetailRepository.getCoinDetail().toDetailPresentationCoin()
            emit(Resource.Success<DetailPresentationCoin>(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<DetailPresentationCoin>(e.localizedMessage ?: "알 수 없는 오류 입니다."))
        } catch (e: IOException) {
            emit(Resource.Error<DetailPresentationCoin>("서버와 연결 할 수 없습니다. 모바일 데이터나 Wi-Fi를 확인 해주세요."))
        }
    }
}

