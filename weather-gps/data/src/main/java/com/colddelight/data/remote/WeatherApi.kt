package com.colddelight.data.remote

import com.colddelight.data.remote.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WeatherApi {
    @GET("1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")
    suspend fun getWeatherData(@QueryMap data: HashMap<String, String>): WeatherResponse
}