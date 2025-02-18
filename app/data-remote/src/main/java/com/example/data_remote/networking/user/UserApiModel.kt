package com.example.data_remote.networking.user

import com.squareup.moshi.Json

data class UserApiModel(
    @Json(name = "id") val id:Long,
    @Json(name = "name") val username:String,
    @Json(name = "email") val email:String
)
