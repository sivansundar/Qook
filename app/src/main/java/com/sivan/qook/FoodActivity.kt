package com.sivan.qook

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.sivan.qook.databinding.ActivityFoodBinding
import com.sivan.qook.model.FoodModel
import com.sivan.qook.ui.home.FoodImageListAdapter

class FoodActivity : AppCompatActivity() {
    lateinit var bundle : Bundle
    lateinit var foodItem: FoodModel
    private lateinit var binding: ActivityFoodBinding

    lateinit var imageAdapter : FoodImageListAdapter
    lateinit var ingredientsAdapter: IngredientsAdapter
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var tabLayoutMediator: TabLayoutMediator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Content View
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FoodImage Adapter
        imageAdapter = FoodImageListAdapter(baseContext)
        ingredientsAdapter = IngredientsAdapter()

        //Food item object
        bundle = intent.extras!!
        foodItem = bundle.getParcelable("food_object")!!
        binding.foodItem = foodItem
        viewPagerAdapter = ViewPagerAdapter(this, foodItem)


        Log.d("TAG", "onCreate: ${foodItem.foodIngredients}")
        imageAdapter.submitList(foodItem.foodImages)
        ingredientsAdapter.submitIngredients(foodItem.foodIngredients)

        //ViewPager
        initViewPager()

        initImageRecyclerView()
        //initIngredientsRecyclerView()

        Toast.makeText(this, "${foodItem.foodType}", Toast.LENGTH_LONG).show()
    }

    private fun initViewPager() {
        binding.viewPager.apply {
            adapter = viewPagerAdapter
        }

        tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, i ->

            when(i) {
                0 -> tab.text = "Ingredients"
                1-> tab.text = "Directions"
                else -> tab.text = "Reviews"
            }
        })
        tabLayoutMediator.attach()

    }

//    private fun initIngredientsRecyclerView() {
//        binding.ingredientsRecyclerView.apply {
//            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
//            adapter = ingredientsAdapter
//        }
//    }

    private fun initImageRecyclerView() {
        binding.foodItemImageRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = imageAdapter
        }
    }
}