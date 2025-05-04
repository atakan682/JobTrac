package com.example.jobtrac.api

import com.example.jobtrac.model.JobResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JobApiService {
    @GET("api/job-board-api")
    suspend fun getJobs(
        @Query("visa_sponsorship") visaSponsorship: Boolean = true
    ): JobResponse
}
