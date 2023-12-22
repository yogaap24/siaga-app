package com.example.siaga.ui.login

import androidx.lifecycle.ViewModel
import com.example.siaga.data.UserRepository
import com.example.siaga.data.api.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun login(email: String, password: String) {
        userRepository.loginUser(email, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    println("Login berhasil dengan email: ${loginResponse?.email}")
                } else {
                    println("Login gagal: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                println("Terjadi kesalahan jaringan: ${t.message}")
            }

        })
    }
}
