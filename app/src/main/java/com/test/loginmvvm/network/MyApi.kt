package com.test.loginmvvm.network

import com.test.loginmvvm.network.response.AuthResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Part

interface MyApi {

    //Here We call POST API
    @FormUrlEncoded
    @POST("User_auh.php?apicall=login")
    fun userLogin(
        @Field("email")email:String,
        @Field("password")password:String
    ):Call<ResponseBody>

    @FormUrlEncoded
    @POST("User_auh.php?apicall=register")
    fun userRegistration(
        @Field("fname") fname: String,
        @Field("lname") lname: String,
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("conf_pass") conf_pass: String,
        @Field("type") type: String,
        @Field("profile_image") profile_image: String

    ): Call<ResponseBody>


    //In side this object retrofit calling handle
    companion object{
        const val BASE_URL="https://memes.co/memesapi/"

        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("https://memes.co/memesapi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}