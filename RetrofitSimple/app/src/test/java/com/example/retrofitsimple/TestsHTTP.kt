package com.example.retrofitsimple

import android.util.Log
import com.example.retrofitsimple.http.RetrofitUtil
import org.junit.Test
import retrofit2.Response



class TestsHTTP {
    @Test
    fun testGet() {
        val service = RetrofitUtil.get()
        val call = service.DoubleNumber(1)
        val response :Response<Int> = call.execute()
        var body : Int? = response.body()
        assert(body!! == 2)
    }
}