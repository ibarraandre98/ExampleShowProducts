package com.cursokotlin.mvvmexample.data.network

import com.cursokotlin.mvvmexample.data.model.DevicesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DevicesService @Inject constructor(private val devicesApiClient: DevicesApiClient) {

    suspend fun getDevices(): DevicesModel{
            return withContext(Dispatchers.IO) {
                val response = devicesApiClient.getAllDevices()
                response.body()!!
            }
    }
}