package com.example.fieldsalessmartgarage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fieldsalessmartgarage.R
import com.example.fieldsalessmartgarage.databinding.FragmentPaymentDetailsBinding

class PaymentDetailsFragment : Fragment(R.layout.fragment_payment_details) {
    private lateinit var binding: FragmentPaymentDetailsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPaymentDetailsBinding.bind(view)
        binding.apply {

        }
    }
}