package com.colddelight.base_example.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkObject {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com"
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).addInterceptor {
        // Request
        val request = it.request()
            .newBuilder()
            .build()
        // Response
        val response = it.proceed(request)
        response
    }.connectTimeout(20, TimeUnit.SECONDS).
    readTimeout(20, TimeUnit.SECONDS).
    writeTimeout(20, TimeUnit.SECONDS).
    build()

    private val getRetrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getRetrofitService : ApiInterface by lazy{
        getRetrofit.create(ApiInterface::class.java)
    }

}