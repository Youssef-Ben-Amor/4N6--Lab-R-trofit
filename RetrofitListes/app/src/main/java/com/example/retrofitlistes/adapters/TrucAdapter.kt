// src/main/java/com/example/retrofitlistes/adapters/TrucAdapter.kt
package com.example.retrofitlistes.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitlistes.databinding.TrucItemBinding
import com.example.retrofitlistes.transfer.Truc

class TrucAdapter : ListAdapter<Truc, TrucAdapter.TrucItemViewHolder>(TrucItemDiffCallback) {

    inner class TrucItemViewHolder(private val binding: TrucItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Truc) {
            binding.ListName.text = item.b
            binding.ListCount.text = item.a.toString()
            binding.listItems.text = item.c.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrucItemViewHolder {
        val binding: TrucItemBinding = TrucItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrucItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrucItemViewHolder, position: Int) {
        val item: Truc = getItem(position)
        holder.bind(item)
    }
}
object TrucItemDiffCallback : DiffUtil.ItemCallback<Truc>() {
    override fun areItemsTheSame(oldItem: Truc, newItem: Truc): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Truc, newItem: Truc): Boolean {
        return oldItem.a == newItem.a &&
                oldItem.b == newItem.b &&
                oldItem.c==newItem.c
    }
}