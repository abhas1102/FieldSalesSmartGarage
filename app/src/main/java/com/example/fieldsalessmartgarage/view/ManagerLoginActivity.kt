package com.example.fieldsalessmartgarage.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fieldsalessmartgarage.R

class ManagerLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager_login)
        supportActionBar!!.hide()
    }
}