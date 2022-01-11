package com.example.faircorp.APIs

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiServices {

    val SpringAPIURL = "http://app-af3be42b-9413-4b80-9e48-c8053e544af2.cleverapps.io"

    val windowsApiService : WindowApiService by lazy {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(SpringAPIURL + "/api/")
                .build()
                .create(WindowApiService::class.java)
    }

    val roomApiService: RoomApiService by lazy {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(SpringAPIURL + "/api/")
                .build()
                .create(RoomApiService::class.java)
    }

    val heaterApiService: HeaterApiService by lazy {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(SpringAPIURL + "/api/")
                .build()
                .create(HeaterApiService::class.java)
    }

    val buildingApiService: BuildingApiService by lazy {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(SpringAPIURL + "/api/")
                .build()
                .create(BuildingApiService::class.java)
    }
}