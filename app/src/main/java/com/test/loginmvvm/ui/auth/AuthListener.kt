package com.test.loginmvvm.ui.auth

import androidx.lifecycle.LiveData


interface AuthListener {

    fun onStarted()
    fun onSuccesses(authResponse: LiveData<String>)
    fun onFailure(message:String)
}