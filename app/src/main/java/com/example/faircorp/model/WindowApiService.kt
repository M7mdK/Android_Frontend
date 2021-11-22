package com.example.faircorp.model

import retrofit2.http.*
import com.example.faircorp.model.WindowDto
import retrofit2.Call

interface WindowApiService {

    @GET("windows")
    fun findAll(): Call<List<WindowDto>>

    @GET("windows")
    fun findAll(@Query("sort") sort: String): Call<List<WindowDto>>

    @GET("windows/{id}")
    fun findById(@Path("id") id: Long): Call<WindowDto>

    @PUT("windows/{id}")
    fun updateWindow(@Path("id") id: Long, @Body window: WindowDto): Call<WindowDto>
}