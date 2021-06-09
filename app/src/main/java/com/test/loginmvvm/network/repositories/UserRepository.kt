package com.test.loginmvvm.network.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.loginmvvm.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun userLogin(email: String, password: String): LiveData<String> {

        val authResponse = MutableLiveData<String>()
         MyApi().userLogin(email, password).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    authResponse.value=response.body()?.string()
                }else{
                    authResponse.value=response.errorBody()?.string()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                authResponse.value = t.message
            }
        })
        return authResponse
    }

    //Function for create Account

    fun userRegistration(fname:String,lname:String,username:String,email:String,password:String,
                         conf_pass:String,type:String,profile_image:String):LiveData<String>{
        val authResponse=MutableLiveData<String>()

        MyApi().userRegistration(fname, lname, username, email, password, conf_pass,type,profile_image).enqueue(
            object :Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful){
                        authResponse.value=response.body()?.string()
                    }else{
                        authResponse.value=response.errorBody()?.string()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    authResponse.value=t.message
                }
            })
        return authResponse
    }
}