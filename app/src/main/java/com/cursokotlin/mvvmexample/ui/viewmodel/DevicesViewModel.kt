package com.cursokotlin.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursokotlin.mvvmexample.data.model.DevicesModel
import com.cursokotlin.mvvmexample.domain.GetDevicesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DevicesViewModel @Inject constructor(
    private val getDevicesUseCase: GetDevicesUseCase
): ViewModel() {

    val devicesModel = MutableLiveData<DevicesModel>()

    fun getAllDevices(){
        viewModelScope.launch {
            val result = getDevicesUseCase.getAllDevices()
            devicesModel.postValue(result)
        }
    }
}