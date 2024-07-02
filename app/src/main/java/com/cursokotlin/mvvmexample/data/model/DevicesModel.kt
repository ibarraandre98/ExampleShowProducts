package com.cursokotlin.mvvmexample.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class DevicesModel(
    val products: List<Products>
)

@Parcelize
data class Products(
    @SerializedName("title") val name: String,
    val description: String,
    val price: Double,
    val thumbnail: String
): Parcelable