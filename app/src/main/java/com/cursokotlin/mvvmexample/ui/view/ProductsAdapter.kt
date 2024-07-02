package com.cursokotlin.mvvmexample.ui.view

import android.app.Activity
import android.bluetooth.BluetoothClass.Device
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.cursokotlin.mvvmexample.R
import com.cursokotlin.mvvmexample.data.model.DevicesModel
import com.cursokotlin.mvvmexample.data.model.Products
import java.text.FieldPosition

class ProductsAdapter(context: Activity, private var callback: (Products) -> Unit): Adapter<ProductsAdapter.MyViewHolder>() {

    private var data: List<Products> = emptyList()
    fun setItems(dataComing: DevicesModel){
        data = dataComing.products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.products, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(itemView: View): ViewHolder(itemView){
        var title = itemView.findViewById<TextView>(R.id.tvTitle)
        var description = itemView.findViewById<TextView>(R.id.tvDescription)
        var price = itemView.findViewById<TextView>(R.id.tvPrice)
        var fl = itemView.findViewById<FrameLayout>(R.id.flProducts)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = data[position]
        holder.title.text = "Nombre: ${currentItem.name}"
        holder.description.text = currentItem.description
        holder.price.text = "Precio: $${currentItem.price}"
        holder.fl.setOnClickListener {
            callback.invoke(currentItem)
        }
    }
}