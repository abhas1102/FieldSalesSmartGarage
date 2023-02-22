package com.example.fieldsalessmartgarage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.fieldsalessmartgarage.R
import com.example.fieldsalessmartgarage.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private var isClicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        supportActionBar!!.hide()

        showOtpScreen()

        binding.buttonLoginBeforeOtp.setOnClickListener {
            isClicked = true
            Log.d("LoginActivity", "Button is clicked")
            Log.d("LoginActivity",isClicked.toString())
            showOtpScreen()
        }


    }

    private fun showOtpScreen() {
        if (isClicked) binding.constraintLayoutOtp.visibility = View.VISIBLE else binding.constraintLayoutOtp.visibility = View.GONE
        Log.d("LoginActivity", isClicked.toString())
    }
}