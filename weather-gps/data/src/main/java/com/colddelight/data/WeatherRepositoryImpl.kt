package com.colddelight.data

import com.colddelight.data.remote.WeatherApi
import com.colddelight.data.remote.response.toDomainWeather
import com.colddelight.domain.model.DomainWeather
import com.colddelight.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val source: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(data: HashMap<String, String>): DomainWeather {
        val resource = source.getWeatherData(data)
        return when(resource.response.header.resultCode) {
            "00" -> resource.toDomainWeather()
            "01" -> throw WeatherApiException.ApplicationErrorException(resource.response.header.resultMsg)
            "02" -> throw WeatherApiException.DataBaseErrorException(resource.response.header.resultMsg)
            "03" -> throw WeatherApiException.NoDataErrorException(resource.response.header.resultMsg)
            "04" -> throw WeatherApiException.HttpErrorException(resource.response.header.resultMsg)
            "05" -> throw WeatherApiException.ServiceTimeOutException(resource.response.header.resultMsg)
            "10" -> throw WeatherApiException.InvalidRequestParameterErrorException(resource.response.header.resultMsg)
            "11" -> throw WeatherApiException.NoMandatoryRequestParametersErrorException(resource.response.header.resultMsg)
            "12" -> throw WeatherApiException.NoOpenApiServiceErrorException(resource.response.header.resultMsg)
            "20" -> throw WeatherApiException.ServiceAccessDeniedErrorException(resource.response.header.resultMsg)
            "21" -> throw WeatherApiException.TemporarilyDisableTheServiceKeyErrorException(resource.response.header.resultMsg)
            "22" -> throw WeatherApiException.LimitedNumberOfServiceRequestsExceedsErrorException(resource.response.header.resultMsg)
            "30" -> throw WeatherApiException.ServiceKeyIsNotRegisteredErrorException(resource.response.header.resultMsg)
            "31" -> throw WeatherApiException.DeadlineHasExpiredErrorException(resource.response.header.resultMsg)
            "32" -> throw WeatherApiException.UnregisteredIpErrorException(resource.response.header.resultMsg)
            "33" -> throw WeatherApiException.UnSignedCallErrorException(resource.response.header.resultMsg)
            "99" -> throw WeatherApiException.UnknownErrorException(resource.response.header.resultMsg)
            else -> throw Throwable()
        }
    }
}