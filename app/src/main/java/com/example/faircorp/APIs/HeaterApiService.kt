package com.example.faircorp.APIs

import com.example.faircorp.model.HeaterDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface HeaterApiService {
    @GET("heaters")
    fun findAll(): Call<List<HeaterDto>>

    @GET("heaters/{id}")
    fun findById(@Path("id") id: Long?): Call<HeaterDto>

    @PUT("heaters/{id}/switch")
    fun switchStatus(@Path("id") id: Long): Call<HeaterDto>
}