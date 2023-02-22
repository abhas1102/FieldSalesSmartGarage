package com.example.fieldsalessmartgarage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.fieldsalessmartgarage.adapter.PartyListAdapter
import com.example.fieldsalessmartgarage.model.AddPartyDataModel
import com.google.android.material.button.MaterialButton


class PartiesFragment : Fragment() {
    private val partyList:ArrayList<AddPartyDataModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        partyList.add(AddPartyDataModel("Krishna Automobile","Krishna", "112222"))
        val view = inflater.inflate(R.layout.fragment_parties, container, false)
       // val toolbar = view.findViewById<Toolbar>(R.id.appBarLayoutHome)
      //  (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        val recyclerViewPartiesFragment:RecyclerView = view.findViewById(R.id.recyclerViewPartiesFragment)
        recyclerViewPartiesFragment.adapter = PartyListAdapter(partyList)

        val buttonAddParty = view.findViewById<MaterialButton>(R.id.buttonAddParty)
        buttonAddParty.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer, AddPartyFragment())?.commit()
        }
        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

    }

   /* override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    } */


}