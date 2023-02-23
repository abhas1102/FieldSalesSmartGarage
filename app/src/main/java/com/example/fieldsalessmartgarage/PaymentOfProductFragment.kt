package com.example.fieldsalessmartgarage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fieldsalessmartgarage.R
import com.example.fieldsalessmartgarage.databinding.FragmentPaymentOfProductBinding

class PaymentOfProductFragment : Fragment(R.layout.fragment_payment_of_product) {
    private lateinit var binding: FragmentPaymentOfProductBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPaymentOfProductBinding.bind(view)
        binding.apply {

        }
    }
}