package com.sivan.qook

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sivan.qook.databinding.DirectionsItemBinding

class DirectionsAdapter : RecyclerView.Adapter<DirectionsAdapter.ViewHolder>() {

    var directionsItem : List<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): DirectionsAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = DirectionsItemBinding.inflate(inflater)

        return ViewHolder(binding)
    }

    fun submitIngredients(list: List<String>?) {
        directionsItem = list!!
    }


    override fun onBindViewHolder(holder: DirectionsAdapter.ViewHolder, position: Int) {
        return holder.bind(directionsItem[position], position)

    }

    override fun getItemCount(): Int = directionsItem.size


    inner class ViewHolder(val binding: DirectionsItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: String, position: Int) {

            binding.directionsItemText.text = "${position+1}. $item"
            Log.d("TAG", "bind: item in ${item}")
            binding.executePendingBindings()

        }
    }
}
