package com.example.tabscrollattacher

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tabscrollattacher.databinding.ItemRowBinding

class RecyclerAdapter(private val itemList : List<Int>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder (val binding : ItemRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.binding.textView.text = itemList[position].toString()
    }


}