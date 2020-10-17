package com.sivan.qook.ui.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sivan.qook.databinding.MainCardItemBinding
import com.sivan.qook.model.FoodModel
import com.sivan.qook.FoodActivity

class FoodMainListAdapter(val context: Context?) :
    RecyclerView.Adapter<FoodMainListAdapter.ViewHolder>() {

     private var items : List<FoodModel> = ArrayList()
     lateinit var currentContext : Context

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainCardItemBinding.inflate(inflater)
        Log.d("FoodMainListAdapter", "onBindViewHolder: ${items[0]}")
        currentContext = context!!


        return ViewHolder(binding, context )
    }

     fun submitList(list : List<FoodModel>) {
         items = list
     }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("FoodMainListAdapter", "onBindViewHolder: ${items[position].foodName}")

        return holder.bind(items[position])

    }


    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val binding: MainCardItemBinding, context: Context) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: FoodModel) {
            binding.foodItem = item
            binding.foodCard.setOnClickListener {
                val intent = Intent(context, FoodActivity::class.java)
                intent.putExtra("food_object", item)
                context?.startActivity(intent)
            }

            binding.executePendingBindings()

        }
    }


}