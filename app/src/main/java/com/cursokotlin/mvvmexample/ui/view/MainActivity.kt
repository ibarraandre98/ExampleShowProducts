package com.cursokotlin.mvvmexample.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cursokotlin.mvvmexample.data.model.Products
import com.cursokotlin.mvvmexample.data.network.DevicesApiClient
import com.cursokotlin.mvvmexample.databinding.ActivityMainBinding
import com.cursokotlin.mvvmexample.ui.viewmodel.DevicesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val devicesViewModel: DevicesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        devicesViewModel.getAllDevices()

        devicesViewModel.devicesModel.observe(this, Observer {
            val productsAdapter = ProductsAdapter(this) {
                val intent = Intent(this, ShowProductsActivity::class.java).apply {
                    putExtra("PRODUCT", it)
                }
                startActivity(intent)
            }
            productsAdapter.setItems(it)
            binding.rvProducts.layoutManager =  LinearLayoutManager(this)
            binding.rvProducts.adapter = productsAdapter
        })
    }
}