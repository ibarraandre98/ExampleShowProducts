package com.cursokotlin.mvvmexample.domain

import com.cursokotlin.mvvmexample.data.model.DevicesModel
import com.cursokotlin.mvvmexample.data.network.DevicesRepository
import javax.inject.Inject

class GetDevicesUseCase @Inject constructor(private val devicesRepository: DevicesRepository){
    suspend fun getAllDevices(): DevicesModel{
        return devicesRepository.getAllDevices()
    }
}