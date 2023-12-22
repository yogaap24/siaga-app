package com.example.siaga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.siaga.data.UserRepository
import com.example.siaga.ui.login.LoginViewModel

class ViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}