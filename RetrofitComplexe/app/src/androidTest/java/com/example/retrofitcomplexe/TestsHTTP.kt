package com.example.retrofitcomplexe
import android.util.Log
import com.example.retrofitcomplexe.http.RetrofitUtil
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response
class TestsHTTP {
    @Test
    fun testHTTP() {
        val service = RetrofitUtil.get()
        val call = service.getComplexe("toto")
        val response: Response<String> = call.execute()
        //Log.d("TestsHTTP", response.body().toString())
        assert(response.body()?.contains("toto") == true)
    }
}