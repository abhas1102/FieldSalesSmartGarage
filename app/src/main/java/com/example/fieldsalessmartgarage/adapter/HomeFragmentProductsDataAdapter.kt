package com.example.fieldsalessmartgarage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fieldsalessmartgarage.databinding.RowItemProductListBinding
import com.example.fieldsalessmartgarage.databinding.RowItemProductsHomeFragmentBinding
import com.example.fieldsalessmartgarage.model.ProductsInHomeFragment

class HomeFragmentProductsDataAdapter(val listItems:ArrayList<ProductsInHomeFragment>)
    :RecyclerView.Adapter<HomeFragmentProductsDataAdapter.ViewHolder>(){

        class ViewHolder(binding:RowItemProductsHomeFragmentBinding):RecyclerView.ViewHolder(binding.root){

            val imageProduct = binding.imageProduct
            val nameProduct = binding.nameProduct

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowItemProductsHomeFragmentBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageProduct.setImageResource(listItems[position].image)
        holder.nameProduct.text = listItems[position].name

    }
}