package com.test.loginmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.test.loginmvvm.R
import com.test.loginmvvm.utils.toast

class CreateAccountActivity : AppCompatActivity(),AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    override fun onStarted() {
        toast("Login Started")
    }

    override fun onSuccesses(authResponse: LiveData<String>) {
        authResponse.observe(this, Observer {
            toast(it)
        })
    }

    override fun onFailure(message: String) {
       toast(message)
    }
}