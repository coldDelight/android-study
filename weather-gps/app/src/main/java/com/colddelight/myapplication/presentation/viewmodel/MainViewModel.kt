package com.colddelight.myapplication.presentation.viewmodel

import android.location.Location
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.colddelight.myapplication.BuildConfig
import com.colddelight.domain.repository.LocationRepository
import com.colddelight.myapplication.presentation.model.WeatherModel
import com.colddelight.myapplication.usecase.WeatherUseCase
import com.colddelight.myapplication.utils.Resource
import com.colddelight.myapplication.utils.TransLocationUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: WeatherUseCase,
    private val tracker: LocationRepository
): ViewModel() {
    data class WeatherState(
        val weatherData: WeatherModel? = null,
        val isLoading: Boolean = true,
        val error: String = ""
    )

    private val _state: MutableStateFlow<WeatherState> = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> get() = _state.asStateFlow()

    private fun createRequestParams(location: Location): HashMap<String, String> {

        val now = LocalDateTime.now()

        val baseTime = when  {
            now.hour > 11 -> {
                if (now.minute < 40) "${now.hour - 1}00"
                else  "${now.hour}00"
            }
            now.hour == 10 -> {
                if (now.minute < 40) "0900"
                else  "1000"
            }
            now.hour in 1..9 -> {
                if (now.minute < 40) "0${now.hour - 1}00"
                else  "0${now.hour}00"
            }
            now.hour == 0 -> {
                if (now.minute < 40) "2300"
                else  "0000"
            }
            else -> "0000"
        }

        val baseDate = if (now.hour != 0) {
            when {
                now.monthValue > 10 && now.dayOfMonth > 10 -> "${now.year}${now.monthValue}${now.dayOfMonth}"
                now.monthValue > 10 && now.dayOfMonth < 10 -> "${now.year}${now.monthValue}0${now.dayOfMonth}"
                now.monthValue < 10 && now.dayOfMonth > 10 -> "${now.year}0${now.monthValue}${now.dayOfMonth}"
                now.monthValue < 10 && now.dayOfMonth < 10 -> "${now.year}0${now.monthValue}0${now.dayOfMonth}"
                else -> "20220801"
            }
        } else {
            val date =
                if (baseTime != "0000") now.minusDays(1)
                else now

            when {
                date.monthValue > 10 && date.dayOfMonth > 10 -> "${date.year}${date.monthValue}${date.dayOfMonth}"
                date.monthValue > 10 && date.dayOfMonth < 10 -> "${date.year}${date.monthValue}0${date.dayOfMonth}"
                date.monthValue < 10 && date.dayOfMonth > 10 -> "${date.year}0${date.monthValue}${date.dayOfMonth}"
                date.monthValue < 10 && date.dayOfMonth < 10 -> "${date.year}0${date.monthValue}0${date.dayOfMonth}"
                else -> "20220801"
            }
        }

        val transLocation = TransLocationUtil.convertLocation(location)
        Log.e("after convert",""+ transLocation.nx +"  "+ transLocation.ny)

        return HashMap<String, String>().apply {
            put("serviceKey", BuildConfig.SERVICE_KEY)
            put("dataType", "JSON")
            put("base_date", baseDate)
            put("base_time", baseTime)
            put("nx", transLocation.nx.toInt().toString())
            put("ny", transLocation.ny.toInt().toString())
        }
    }

    fun getWeatherData(city:String) {
        viewModelScope.launch {
            _state.value = WeatherState(
                isLoading = true
            )
            if(city=="my"){

            }else{

            }
            tracker.getCurrentLocation()?.let { location ->
                useCase.invoke(createRequestParams(location)).onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.value = WeatherState(
                                isLoading = false,
                                weatherData = result.data
                            )
                        }
                        is Resource.Error -> {
                            _state.value = WeatherState(
                                isLoading = false,
                                error = result.message ?: "알 수 없는 에러."
                            )
                        }
                    }
                }.launchIn(viewModelScope)
            }
        }
    }
}