package com.cursokotlin.mvvmexample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.cursokotlin.mvvmexample.R
import com.cursokotlin.mvvmexample.data.model.Products
import com.cursokotlin.mvvmexample.databinding.ActivityShowProductsBinding

class ShowProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getParcelableExtra<Products>("PRODUCT")
        product.let {
            binding.tvTitle.text = it?.name
            binding.tvDescription.text = it?.description
            binding.tvPrice.text = "Precio: $${it?.price.toString()}"
            Glide.with(this).load(it?.thumbnail).into(binding.ivProduct)
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    companion object{

    }
}