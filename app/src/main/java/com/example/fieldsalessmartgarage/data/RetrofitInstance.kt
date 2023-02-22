package com.example.fieldsalessmartgarage.data

import android.util.Log
import com.example.fieldsalessmartgarage.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var apiBuilder:Retrofit? = null
    val baseUrl = Constants.base_url
  /*  fun getInstance():Retrofit{
        if(apiBuilder == null){
         val  apiBuilder1 =  Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            Log.d("Craete object","Object created")
            apiBuilder = apiBuilder1
        }
        return apiBuilder!!
    }*/

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        retrofit.create(Api::class.java)

    }

}