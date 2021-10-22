package com.example.service_api_72190327.Network

import com.example.service_api_72190327.Models.ResponseKuliahItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class NetworkConfig {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.42.204/slim-matakuliah/public/api/progmob/matkul/72190327/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
}
interface Users {
    @GET("api/progmob/matkul/72190327")
    fun getKuliahAll(): Call<ResponseKuliahItem>

    @GET("api/progmob/matkul/72190327/{kode}")
    fun getKuliah(): Call<ResponseKuliahItem>
}
