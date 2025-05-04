package com.example.jobtrac.model

data class JobResponse(
    val data: List<JobItem>
)

data class JobItem(
    val title: String,
    val company: String,
    val location: String,
    val description: String,
    val remote: Boolean,
    val url: String
)