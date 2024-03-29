package com.colddelight.domain.repository

import android.location.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location?
}