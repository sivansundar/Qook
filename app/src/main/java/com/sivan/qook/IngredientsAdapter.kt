package com.sivan.qook

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sivan.qook.databinding.IngredientsListItemBinding
import com.sivan.qook.ui.home.HomeViewModel
import java.text.FieldPosition

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    var ingredientsItem : List<String> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): IngredientsAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = IngredientsListItemBinding.inflate(inflater)



        return ViewHolder(binding)

    }

    fun submitIngredients(list: List<String>?) {
        ingredientsItem = list!!
    }


    override fun onBindViewHolder(holder: IngredientsAdapter.ViewHolder, position: Int) {

        return holder.bind(ingredientsItem[position])
    }

    override fun getItemCount(): Int = ingredientsItem.size

    inner class ViewHolder(val binding: IngredientsListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : String) {

            binding.ingredientItemText.text = item
            Log.d("TAG", "bind: item in ${item}")
            binding.executePendingBindings()

        }
    }

}
