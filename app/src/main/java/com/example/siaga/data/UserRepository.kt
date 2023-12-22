package com.example.siaga.data

import com.example.siaga.data.api.ApiService
import com.example.siaga.data.api.LoginResponse
import com.example.siaga.data.pref.UserModel
import retrofit2.Call

class UserRepository(private val apiService: ApiService) {
    fun loginUser(email: String, password: String): Call<LoginResponse> {
        return apiService.login(UserModel(email, password))
    }
}
