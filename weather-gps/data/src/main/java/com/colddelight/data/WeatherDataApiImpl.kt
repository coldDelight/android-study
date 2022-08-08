package com.colddelight.data

import com.colddelight.data.remote.WeatherApi
import com.colddelight.data.remote.response.WeatherResponse
import retrofit2.Retrofit
import javax.inject.Inject

class WeatherDataApiImpl @Inject constructor(
    private val retrofit: Retrofit
): WeatherApi{
    override suspend fun getWeatherData(data: HashMap<String, String>): WeatherResponse {
        return retrofit.create(WeatherApi::class.java).getWeatherData(data)
    }

}