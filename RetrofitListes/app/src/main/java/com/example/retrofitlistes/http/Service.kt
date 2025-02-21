package com.example.retrofitlistes.http

import com.example.retrofitlistes.transfer.Truc
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("exos/long/list")
    fun getLongList(): Call<List<Long>>
    @GET("exos/truc/list")
    fun getTrucList(): Call<List<Truc>>
}