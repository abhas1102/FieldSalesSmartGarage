package com.example.fieldsalessmartgarage.fragments

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.fieldsalessmartgarage.R
import com.example.fieldsalessmartgarage.databinding.FragmentChequeListBinding


class ChequeListFragment : Fragment(R.layout.fragment_cheque_list) {
    private lateinit var binding:FragmentChequeListBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentChequeListBinding.bind(view)
        binding.apply {
            filterBtn.setOnClickListener {
                showFilterDialog()
            }
        }
    }

    private fun showFilterDialog() {
        val dialog=Dialog(requireContext())
        dialog.setContentView(R.layout.cheque_filter_dialog_box)
        dialog.window!!.setLayout(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.dialog_box_background))
        dialog.show();
    }
}