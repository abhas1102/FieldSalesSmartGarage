package com.example.fieldsalessmartgarage.model

data class CheckinDetailsModel(
    val shopName:String,
    val shopOwnerName:String,
   // val pinCode:String,
    val mobileNumber:String,
   // val images:ArrayList<String>,
   // val checkInTime: String,
   // val checkOutTime:String,
   // val purposeOfVisit:String,
   // val nameOfSalesManager:String
    )
data class ItemDataOnHomeFragmentModel(
    val image:Int,
    val name: String
)
data class ItemOffersInHomeFragmentModel(
    val image:Int
)
data class ProductsInHomeFragment(
    val image: Int,
    val name: String
)