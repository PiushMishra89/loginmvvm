package com.test.loginmvvm.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.test.loginmvvm.network.repositories.UserRepository

class AuthViewModel:ViewModel() {
    var fname:String?=null
    var lname:String?=null
    var username:String?=null
    var email:String?=null
    var password:String?=null
    var conf_pass:String?=null
    var type:String?=""
    var profile_image:String?=""
    var authListener:AuthListener?=null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if (email.isNullOrEmpty()||password.isNullOrEmpty()){
            authListener?.onFailure("Invalid Email or Password")
            return
        }
        val authResponse= UserRepository().userLogin(email!!,password!!)
        authListener?.onSuccesses(authResponse)

    }

    fun singUp(view: View){
        Intent(view.context,CreateAccountActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onRegistrationButtonClick(view:View){
        authListener?.onStarted()

        val authResponse=UserRepository().userRegistration(fname!!,lname!!,username!!,email!!,password!!,conf_pass!!,type!!,profile_image!!)
        authListener?.onSuccesses(authResponse)
    }
}