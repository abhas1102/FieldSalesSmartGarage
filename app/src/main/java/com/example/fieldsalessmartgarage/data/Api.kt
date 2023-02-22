package com.example.fieldsalessmartgarage.data

import com.example.fieldsalessmartgarage.constants.Constants
import com.example.fieldsalessmartgarage.model.OtpResponse
import com.example.fieldsalessmartgarage.model.VerifyOtpResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("${Constants.api_key}/SMS/{phone_number}/AUTOGEN2/OTP1")
    suspend fun getOtp(@Path("phone_number") phone_number:String): Response<OtpResponse>

    @GET("${Constants.api_key}/SMS/VERIFY/{otp_session_id}/{otp_entered_by_user}")
    suspend fun verifyOtp(@Path("otp_session_id") sessionId:String, @Path("otp_entered_by_user") otp:String): Response<VerifyOtpResponse>
}