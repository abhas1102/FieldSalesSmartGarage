package com.example.fieldsalessmartgarage.view

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.fieldsalessmartgarage.R
import com.example.fieldsalessmartgarage.constants.Constants
import com.example.fieldsalessmartgarage.data.Api
import com.example.fieldsalessmartgarage.data.RetrofitInstance
import com.example.fieldsalessmartgarage.databinding.ActivitySignupBinding
import com.example.fieldsalessmartgarage.model.VerifyOtpResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    private lateinit var finalOtpString: String
    private lateinit var otpsessionId:String



    lateinit var binding:ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_signup)

       // finalOtpString = "${binding.otpBoxtFirst.text.toString()}${binding.otpBoxtTwo.text.toString()}${binding.otpBoxtThree.text.toString()}${binding.otpBoxtFour.text.toString()}${binding.otpBoxtFive.text.toString()}${binding.otpBoxtSix.text.toString()}  "

        supportActionBar!!.hide()
     /*   binding.btnSignup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            val api = RetrofitInstance.getInstance().create(Api::class.java)
            GlobalScope.launch {
                val result = api.getOtp(binding.editTextMobileNumber.text.toString())
                if (result!=null){
                    Log.d("signup",result.body()!!.Details)
                    Log.d("url", result.raw().request().url().toString())
                }
            }
        } */
        hideEnterOtpViews()

        binding.btnSignup.setOnClickListener {
            hideRequestOtpViews()
            showOtpViews()
           // val api = RetrofitInstance.getInstance().create(Api::class.java)
            Log.d("api1 address", "${RetrofitInstance.instance}")
            Log.d("api2 address", "${RetrofitInstance.instance}")
          //  val api2 = RetrofitInstance.getInstance(Constants.api_key).create(Api::class.java)
         //   val api2 = RetrofitInstance.getInstance().create(Api::class.java)
          //  if (api == api2) Log.d("Check Object Equalisation", "Same object")


           GlobalScope.launch {

                val result = RetrofitInstance.instance.getOtp(binding.editTextMobileNumber.text.toString())
                otpsessionId = result.body()!!.Details

                if (result!=null){

                    Log.d("signup",result.body()!!.Details)
                    Log.d("url", result.raw().request().url().toString())
                }
            }

        }

        binding.btnSubmitOtp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
          /*  finalOtpString = binding.otpBoxFirst.text.toString()
            Log.d("finalotp", finalOtpString)
            GlobalScope.launch {
                Log.d("otpsessionid", otpsessionId)

               val resultVerifyOtp = RetrofitInstance.instance.verifyOtp(otpsessionId, finalOtpString)
                Log.d("verifyotpurl", resultVerifyOtp.raw().request().url().toString())
              /*  if (resultVerifyOtp.body()!!.Details == "OTP Matched" ){
                  //  Log.d("Verify otp", resultVerifyOtp.body().toString())
                   // Log.d("otpString", finalOtpString)

                } */
                if (resultVerifyOtp.body()!!.Details == "OTP Matched") {
                    val intent = Intent(this@SignupActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            } */


        }

    }
    fun hideEnterOtpViews() {
        binding.enterOtpLayout.visibility = View.GONE
        binding.textVerificationCode.visibility = View.GONE
        binding.imageCentreEnterOtpScreen.visibility = View.GONE
    }
    fun hideRequestOtpViews() {
        binding.layoutMobileVerify.visibility = View.GONE
        binding.textPhone.visibility = View.GONE
        binding.imageCentre.visibility = View.GONE
    }
    fun showOtpViews() {
        binding.enterOtpLayout.visibility = View.VISIBLE
        binding.textVerificationCode.visibility = View.VISIBLE
        binding.imageCentreEnterOtpScreen.visibility = View.VISIBLE
    }
}