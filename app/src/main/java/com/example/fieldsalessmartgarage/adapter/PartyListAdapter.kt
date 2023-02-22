package com.example.fieldsalessmartgarage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fieldsalessmartgarage.databinding.RowItemPartyScreenBinding
import com.example.fieldsalessmartgarage.model.AddPartyDataModel

class PartyListAdapter(val listItems:ArrayList<AddPartyDataModel>):RecyclerView.Adapter<PartyListAdapter.ViewHolder>() {
    class ViewHolder(binding: RowItemPartyScreenBinding):RecyclerView.ViewHolder(binding.root){
        val businessName:TextView = binding.partyBusinessName
        val businessOwnerName:TextView = binding.partyOwnerName
        val partyCode:TextView = binding.partyCode
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowItemPartyScreenBinding.inflate(
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
        holder.businessName.text = listItems[position].partyName
        holder.businessOwnerName.text = listItems[position].contactPersonName
        holder.partyCode.text = listItems[position].shopCode
    }
}