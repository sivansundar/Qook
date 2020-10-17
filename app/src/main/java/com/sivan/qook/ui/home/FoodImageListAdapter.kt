package com.sivan.qook.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sivan.qook.databinding.FooditemImageItemBinding

class FoodImageListAdapter (val context: Context?) :
        RecyclerView.Adapter<FoodImageListAdapter.ViewHolder>() {

    private var items : List<String> = ArrayList()
    lateinit var currentContext : Context


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): FoodImageListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = FooditemImageItemBinding.inflate(inflater)
        currentContext = context!!

        return ViewHolder(binding, context)
    }

    fun submitList(list: List<String>?) {
        items = list!!
    }

    override fun onBindViewHolder(holder: FoodImageListAdapter.ViewHolder, position: Int) {
        return holder.bind((items[position]))
    }

    override fun getItemCount(): Int = items.size


    inner class ViewHolder(val binding: FooditemImageItemBinding, context: Context) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: String) {


                Log.d("TAG", "bind: Images : ${item}")
                context?.let { Glide.with(it).load(item).into(binding.foodItemImage) }


            binding.executePendingBindings()

        }
    }
}