package com.example.fieldsalessmartgarage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.fieldsalessmartgarage.R
import com.example.fieldsalessmartgarage.databinding.FragmentCollectionDetailBinding


class CollectionDetailFragment : Fragment(R.layout.fragment_collection_detail) {
    private lateinit var binding: FragmentCollectionDetailBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCollectionDetailBinding.bind(view)
    }
}