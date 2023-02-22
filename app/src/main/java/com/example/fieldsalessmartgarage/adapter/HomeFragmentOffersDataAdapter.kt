package com.example.fieldsalessmartgarage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.fieldsalessmartgarage.databinding.RowOffersItemHomeFragBinding
import com.example.fieldsalessmartgarage.model.ItemOffersInHomeFragmentModel

class HomeFragmentOffersDataAdapter(val listItems:ArrayList<ItemOffersInHomeFragmentModel>)
    :RecyclerView.Adapter<HomeFragmentOffersDataAdapter.ViewHolder>(){

        class ViewHolder(val binding:RowOffersItemHomeFragBinding):RecyclerView.ViewHolder(binding.root) {

           val imageOffers = binding.imageOffers

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowOffersItemHomeFragBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageOffers.setImageResource(listItems[position].image)
    }
}