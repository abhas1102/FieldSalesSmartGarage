package com.example.fieldsalessmartgarage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fieldsalessmartgarage.R
import com.example.fieldsalessmartgarage.databinding.FragmentCollectionBinding


class CollectionFragment : Fragment(R.layout.fragment_collection) {
    private lateinit var binding:FragmentCollectionBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentCollectionBinding.bind(view)
        binding.apply {

        }
    }
}