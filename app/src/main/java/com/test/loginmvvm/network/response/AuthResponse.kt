package com.test.loginmvvm.network.response

import com.test.loginmvvm.data.entities.User


data class AuthResponse(
    val error:String?,
    val status:String?,
    val message:String?,
    val user: User?,
)