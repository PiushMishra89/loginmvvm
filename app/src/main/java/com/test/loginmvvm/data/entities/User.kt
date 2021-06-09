package com.test.loginmvvm.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID=0

@Entity
data class User(
   val id:Int?,
   val username:String?=null,
   val fname:String?=null,
   val lname:String?=null,
   val about:String?=null,
   val gender:String?=null,
   val email:String?=null,
){
    @PrimaryKey(autoGenerate = false)
    var uid:Int= CURRENT_USER_ID
}