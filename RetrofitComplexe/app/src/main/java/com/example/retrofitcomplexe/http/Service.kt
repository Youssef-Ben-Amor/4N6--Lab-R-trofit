package com.example.retrofitcomplexe.http
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("exos/truc/complexe")
    fun getComplexe(@Query("name") name: String): Call<String>
}