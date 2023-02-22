package com.example.fieldsalessmartgarage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.fieldsalessmartgarage.model.AddPartyDataModel
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.NonDisposableHandle.parent


class AddPartyFragment : Fragment(), AdapterView.OnItemClickListener {
    lateinit var autoCompleteTextView:AutoCompleteTextView
    lateinit var selectedState:String
   // private val partyList:ArrayList<AddPartyDataModel> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_add_party, container, false)
       // val toolbar:Toolbar = view.findViewById(R.id.addPartyToolbar)
        //(activity as? AppCompatActivity)?.setSupportActionBar(toolbar)?.setDisplayHomeAsUpEnabled(true)
        autoCompleteTextView = view.findViewById(R.id.autocomplete)
        val listOfStates = listOf("Haryana", "Bengal", "Gujarat", "Bihar")
        val adapter = ArrayAdapter(view.context, R.layout.list_states, listOfStates)
        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setOnItemClickListener(this)
        val button :MaterialButton = view.findViewById(R.id.buttonSubmitAddParty)
        button.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer, PartiesFragment())?.commit()
        }
        return view
    }


    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val item = p0?.getItemAtPosition(p2).toString()
        selectedState = item
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