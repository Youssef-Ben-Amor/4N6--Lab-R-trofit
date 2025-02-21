package com.example.retrofitlistes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.retrofitlistes.adapters.MonAdapter
import com.example.retrofitlistes.adapters.TrucAdapter
import com.example.retrofitlistes.databinding.ActivityMainBinding
import com.example.retrofitlistes.http.RetrofitUtil
import com.example.retrofitlistes.http.Service
import com.example.retrofitlistes.transfer.Truc
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter1: MonAdapter
    private lateinit var adapter2: TrucAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecycler2()
        fillRecycler2()
        setupRecycler1()
        fillRecycler1()
    }

    private fun fillRecycler2() {
        RetrofitUtil.get().getTrucList().enqueue(object : Callback<List<Truc>> {
            override fun onResponse(call: Call<List<Truc>>, response: Response<List<Truc>>) {
                adapter2.submitList(response.body())
            }

            override fun onFailure(call: Call<List<Truc>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun setupRecycler2() {
        adapter2 = TrucAdapter() // Créer l'adapteur
        binding.rvTrucAdapter.adapter = adapter2 // Assigner l'adapteur au RecyclerView
        binding.rvTrucAdapter.setHasFixedSize(true) // Option pour améliorer les performances
        binding.rvTrucAdapter.addItemDecoration( // Ajouter un séparateur entre chaque élément
            DividerItemDecoration(
                binding.rvTrucAdapter.context, DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun fillRecycler1() {
        RetrofitUtil.get().getLongList().enqueue(object : Callback<List<Long>> {
            override fun onResponse(call: Call<List<Long>>, response: Response<List<Long>>) {
                adapter1.submitList(response.body())
            }

            override fun onFailure(call: Call<List<Long>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun setupRecycler1() {
        adapter1 = MonAdapter() // Créer l'adapteur
        binding.rvMonAdapter.adapter = adapter1 // Assigner l'adapteur au RecyclerView
        binding.rvMonAdapter.setHasFixedSize(true) // Option pour améliorer les performances
        binding.rvMonAdapter.addItemDecoration( // Ajouter un séparateur entre chaque élément
            DividerItemDecoration(
                binding.rvMonAdapter.context, DividerItemDecoration.VERTICAL
            )
        )
    }
}