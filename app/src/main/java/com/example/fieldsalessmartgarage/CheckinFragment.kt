package com.example.fieldsalessmartgarage

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.example.fieldsalessmartgarage.adapter.CheckinFragmentAdapter
import com.example.fieldsalessmartgarage.databinding.FragmentCheckinBinding
import com.example.fieldsalessmartgarage.model.CheckinDetailsModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class CheckinFragment : Fragment() {
    private lateinit var bindingCheckinFragment:FragmentCheckinBinding
    private lateinit var fusedLocationClient:FusedLocationProviderClient
    private var checkinListData:ArrayList<CheckinDetailsModel> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        bindingCheckinFragment = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_checkin)
        val view = inflater.inflate(R.layout.fragment_checkin,container,false)
        (activity as AppCompatActivity).supportActionBar!!.hide()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())



       bindingCheckinFragment.btnCheckIn.setOnClickListener {
           fetchLocation()
          /* if (ActivityCompat.checkSelfPermission(
                   requireActivity(),
                   Manifest.permission.ACCESS_FINE_LOCATION
               ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                   requireContext(),
                   Manifest.permission.ACCESS_COARSE_LOCATION
               ) != PackageManager.PERMISSION_GRANTED
           ) {
               // TODO: Consider calling
               //    ActivityCompat#requestPermissions
               // here to request the missing permissions, and then overriding
               //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
               //                                          int[] grantResults)
               // to handle the case where the user grants the permission. See the documentation
               // for ActivityCompat#requestPermissions for more details.
               ActivityCompat.requestPermissions(requireActivity(),arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),102)
               return@setOnClickListener

           }

           fusedLocationClient.lastLocation.addOnSuccessListener {
               if (it!=null){
                   Log.d("LocationCheckinFrag", "${it.longitude} ${it.longitude}")
               }

           } */
           Log.d("LocationCheckinFrag", "Click observed")
          // isLocationPermissionGranted()


       }
        bindingCheckinFragment.btnSubmit.setOnClickListener {
            checkinListData.add(
                CheckinDetailsModel(bindingCheckinFragment.editTextShopName.text.toString(),
            bindingCheckinFragment.editTextShopOwnerName.text.toString(), bindingCheckinFragment.editTextShopMobileNumber.text.toString())
            )

            Log.d("CheckinFragment", bindingCheckinFragment.shopName.toString())
            bindingCheckinFragment.layoutForm.visibility = View.GONE
            bindingCheckinFragment.checkinRecyclerView.adapter =CheckinFragmentAdapter(checkinListData)
            Log.d("FragmentCheckin",checkinListData.toString())



        }



        return view
    }

    fun formData() {
        val shopName = bindingCheckinFragment.shopName.text.toString()
        val shopOwnerName = bindingCheckinFragment.shopOwnerName.text.toString()
        val mobileNumber = bindingCheckinFragment.shopMobileNumber.text.toString()


    }

 /*   private fun isLocationPermissionGranted(): Boolean {

        return if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                101
            )
            val task = fusedLocationClient.lastLocation
            task.addOnSuccessListener {
                Log.d("FragmentCheckin", "${it.toString()}")
                if (it!=null) {
                    Toast.makeText(
                        requireContext(),
                        "${it.latitude} ${it.longitude}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            false
        } else {
            true
        }


    } */

    private fun fetchLocation() {

        if (ActivityCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION)
        !=PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
        !=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return
        }
        val task = fusedLocationClient.lastLocation
        task.addOnSuccessListener {
            Log.d("FragmentCheckin", "${it.toString()}")
            if (it!=null) {
                Toast.makeText(
                    requireContext(),
                    "${it.latitude} ${it.longitude}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }


}