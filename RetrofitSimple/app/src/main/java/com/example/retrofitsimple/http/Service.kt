package com.example.retrofitsimple.http
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
interface Service {
    @GET("exos/long/double/{number}")
    fun DoubleNumber(@Path("number") number: Int): Call<Int>
}