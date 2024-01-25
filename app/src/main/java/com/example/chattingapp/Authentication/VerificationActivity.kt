package com.example.chattingapp.Authentication

import android.content.Context
import android.graphics.drawable.PictureDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import com.example.chattingapp.R
import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView


class VerificationActivity : AppCompatActivity() {

    private lateinit var otpTextView: OtpTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        otpTextView = findViewById(R.id.otp_view)

        // Set focus to OtpTextView
        otpTextView.requestFocus()

        otpTextView.otpListener=(object :OTPListener {


            override fun onInteractionListener() {



            }

            override fun onOTPComplete(otp: String) {
                Toast.makeText(this@VerificationActivity,"The otp is "+otp,Toast.LENGTH_LONG).show()

            }
        })




    }


    override fun onResume() {
        super.onResume()
        showSoftKeyboard(otpTextView)
    }

    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}