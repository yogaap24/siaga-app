package com.example.siaga.ui.setting

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.siaga.R
import java.util.Locale

class SettingsViewModel : ViewModel() {
    val selectedLanguage = mutableStateOf("")

    fun loadLanguagePreference(context: Context) {
        val sharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE)
        selectedLanguage.value = sharedPreferences.getString("selectedLanguage", "Indonesia") ?: "Indonesia"
        updateLocale(context, selectedLanguage.value)
    }

    fun saveLanguagePreference(context: Context, language: String) {
        val sharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("selectedLanguage", language)
            apply()
        }
        selectedLanguage.value = language
        updateLocale(context, language)
    }

    private fun updateLocale(context: Context, language: String) {
        val locale = when (language) {
            "English" -> Locale("en")
            "Indonesia" -> Locale("in")
            else -> Locale.getDefault()
        }
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }

    fun onLanguageSelected(language: String) {
        if (selectedLanguage.value != language) {
            selectedLanguage.value = language
        }
    }
}
