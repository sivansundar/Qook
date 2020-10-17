package com.sivan.qook

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sivan.qook.model.FoodModel

class ViewPagerAdapter(activity: AppCompatActivity, foodItem: FoodModel) : FragmentStateAdapter(activity) {

    val foodItem = foodItem

    override fun getItemCount(): Int  = 3

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return IngredientsFragment(foodItem)
            1 -> return DirectionsFragment(foodItem)
            else-> return DirectionsFragment(foodItem)
        }
    }


}