package com.cursokotlin.mvvmexample.data.network

import com.cursokotlin.mvvmexample.data.model.DevicesModel
import retrofit2.Response
import retrofit2.http.GET

interface DevicesApiClient {
    @GET("products")
    suspend fun getAllDevices(): Response<DevicesModel>
}