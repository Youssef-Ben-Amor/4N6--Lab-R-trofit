package com.example.retrofitenvoipost

import com.example.retrofitenvoipost.http.RetrofitUtil
import com.example.retrofitenvoipost.transfer.Truc
import org.junit.Test

class TestsHTTP {
    @Test
    fun testDoubler() {
        val service= RetrofitUtil.get()
        val truc = Truc()
        truc.a = 5
        truc.b = "toto"
        truc.c = listOf(1, 2, 3)
        val request = service.doubler(truc)
        val response = request.execute()
        val body = response.body()
        assert(body!!.contains("toto"))
        //afficjer body dans le logcat
        println(body)
    }

}