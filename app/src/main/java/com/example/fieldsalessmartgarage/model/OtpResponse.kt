package com.example.fieldsalessmartgarage.model

data class OtpResponse(
    val Details: String,
    val Status: String
)
data class VerifyOtpResponse(
    val Status:String,
    val Details:String
)