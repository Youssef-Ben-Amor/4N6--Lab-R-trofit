package com.example.retrofitcomplexe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofitcomplexe.databinding.ActivityMainBinding
import com.example.retrofitcomplexe.http.RetrofitUtil
import com.example.retrofitcomplexe.http.Service

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        binding.submitButton.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val service: Service = RetrofitUtil.get()
            val call = service.getComplexe(name)
            call.enqueue(object : retrofit2.Callback<String> {
                override fun onResponse(call: retrofit2.Call<String>, response: retrofit2.Response<String>) {
                    if (response.isSuccessful)
                    binding.resultText.text = response.body()
                    else
                    binding.resultText.text = "REPONSE ERREUR : " + response.code()
                }
                override fun onFailure(call: retrofit2.Call<String>, t: Throwable) {
                    binding.resultText.text = "PAS DE REPONSE : " + t.message
                }
            })
        }
    }
}