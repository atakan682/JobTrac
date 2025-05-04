package com.example.jobtrac.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.jobtrac.api.JobApiService

object RetrofitClient {
    private const val BASE_URL = "https://www.arbeitnow.com/"

    val api: JobApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JobApiService::class.java)
    }
}


