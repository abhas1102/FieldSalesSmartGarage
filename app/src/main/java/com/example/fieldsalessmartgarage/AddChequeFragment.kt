package com.example.fieldsalessmartgarage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fieldsalessmartgarage.R
import com.example.fieldsalessmartgarage.databinding.FragmentAddChequeBinding


class AddChequeFragment : Fragment(R.layout.fragment_add_cheque) {
    private lateinit var binding: FragmentAddChequeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentAddChequeBinding.bind(view)
        binding.apply {

        }
    }
}