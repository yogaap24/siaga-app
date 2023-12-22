package com.example.siaga.data.api

import androidx.viewbinding.BuildConfig
import com.example.siaga.data.UserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    fun provideRetrofit(): Retrofit {
        val loggingInterceptor = if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://siagasurabaya.my.id/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepository(apiService)
    }
}
