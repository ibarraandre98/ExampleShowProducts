package com.cursokotlin.mvvmexample.data.network

import com.cursokotlin.mvvmexample.data.model.DevicesModel
import javax.inject.Inject

class DevicesRepository @Inject constructor(private val devicesService: DevicesService) {
    suspend fun getAllDevices(): DevicesModel {
        return devicesService.getDevices()
    }
}