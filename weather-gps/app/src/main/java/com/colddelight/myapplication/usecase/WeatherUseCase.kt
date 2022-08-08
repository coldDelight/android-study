package com.colddelight.myapplication.usecase

import com.colddelight.data.WeatherApiException
import com.colddelight.domain.repository.WeatherRepository
import com.colddelight.myapplication.presentation.model.WeatherModel
import com.colddelight.myapplication.presentation.model.toWeatherModel
import com.colddelight.myapplication.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
){
    suspend fun invoke(data: HashMap<String, String>): Flow<Resource<WeatherModel>> = flow {
        try {
            val weatherModel = repository.getWeatherData(data).toWeatherModel()
            emit(Resource.Success<WeatherModel>(weatherModel))
        } catch (t: WeatherApiException) {
            emit(Resource.Error<WeatherModel>(t.message ?: ""))
        } catch (t: Throwable) {
            emit(Resource.Error<WeatherModel>(t.message ?: ""))
        }
    }
}