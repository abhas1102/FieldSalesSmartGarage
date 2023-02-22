package com.example.fieldsalessmartgarage.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.fieldsalessmartgarage.clicklistener.ClickListener
import com.example.fieldsalessmartgarage.databinding.RowDataItemsHomeFragBinding
import com.example.fieldsalessmartgarage.databinding.RowItemGarageCheckedInBinding
import com.example.fieldsalessmartgarage.listener.Listener
import com.example.fieldsalessmartgarage.model.ItemDataOnHomeFragmentModel

class HomeFragmentGridDataAdapter(val listItems:ArrayList<ItemDataOnHomeFragmentModel>, val clickListener:Listener):RecyclerView.Adapter<HomeFragmentGridDataAdapter.ViewHolder>() {

    class ViewHolder(val binding: RowDataItemsHomeFragBinding):RecyclerView.ViewHolder(binding.root) {
        val itemName:TextView = binding.itemText
        val itemImage:ImageView = binding.itemImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowDataItemsHomeFragBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(listItems[position].image)
        holder.itemName.text = listItems[position].name
        holder.binding.root.setOnClickListener {
            Log.d("click_listener_grid_items",listItems.get(position).name)
            clickListener.onClick(itemDataOnHomeFragment = listItems.get(position))
        }

    }
}