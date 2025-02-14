package com.example.retrofitsimple

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofitsimple.databinding.ActivityMainBinding
import com.example.retrofitsimple.http.RetrofitUtil
import com.example.retrofitsimple.http.Service


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        binding.doubleButton.setOnClickListener {
            val service: Service = RetrofitUtil.get()
            val number: Int = binding.numberInput.text.toString().toInt()
            val call = service.DoubleNumber(number)
            call.enqueue(object : retrofit2.Callback<Int> {
                override fun onResponse(call: retrofit2.Call<Int>, response: retrofit2.Response<Int>) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        binding.resultText.text = body.toString()
                    }
                    else
                        binding.resultText.text = "REPONSE ERREUR : " + response.code()
                }

                override fun onFailure(call: retrofit2.Call<Int>, t: Throwable) {
                    binding.resultText.text ="PAS DE REPONSE : " + t.message
                }
            })
        }
    }
}