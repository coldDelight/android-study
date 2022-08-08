package com.colddelight.domain.repository

import com.colddelight.domain.model.DomainWeather

interface WeatherRepository {

    suspend fun getWeatherData(data: HashMap<String, String>): DomainWeather
}