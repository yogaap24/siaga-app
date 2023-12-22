package com.example.siaga.data.api

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
