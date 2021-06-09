package com.test.loginmvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.test.loginmvvm.R
import com.test.loginmvvm.databinding.ActivityLoginBinding
import com.test.loginmvvm.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel=viewModel
        viewModel.authListener=this
    }

    override fun onStarted() {
        toast("Login Started")
    }

    override fun onSuccesses(authResponse: LiveData<String>) {
        //loginResponse.observe()
        authResponse.observe(this, Observer {
            toast(it)
        })
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}