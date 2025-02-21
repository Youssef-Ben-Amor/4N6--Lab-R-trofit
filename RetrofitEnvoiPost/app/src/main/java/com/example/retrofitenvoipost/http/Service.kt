package com.example.retrofitenvoipost.http

import com.example.retrofitenvoipost.transfer.Truc
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Service {
    @POST("exos/truc/doubler")
    fun doubler(@Body truc: Truc): Call<String>

}