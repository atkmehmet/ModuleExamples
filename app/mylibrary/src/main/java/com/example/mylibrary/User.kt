package com.example.mylibrary

data class User(
    val id:String,
    val firstName:String,
    val lastName:String,
    val email:String
){
    fun getFullName() = "$firstName $lastName"
}
