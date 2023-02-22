package com.example.fieldsalessmartgarage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fieldsalessmartgarage.databinding.RowItemGarageCheckedInBinding
import com.example.fieldsalessmartgarage.model.CheckinDetailsModel

class CheckinFragmentAdapter(val checkinItems:ArrayList<CheckinDetailsModel>):
    RecyclerView.Adapter<CheckinFragmentAdapter.ViewHolder>(){

        class ViewHolder(val binding:RowItemGarageCheckedInBinding):RecyclerView.ViewHolder(binding.root){
            fun bind(data:CheckinDetailsModel) {
                binding.checkInItemDetails = data
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowItemGarageCheckedInBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
       return checkinItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data = checkinItems[position])
        holder.binding.btnCheckoutOnItem.setOnClickListener {

        }
    }


}