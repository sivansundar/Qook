package com.sivan.qook.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sivan.qook.FirebaseRepository
import com.sivan.qook.model.FoodModel


class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Let's Qook your favourite food!"
    }

    var foodListLiveData: LiveData<List<FoodModel>>? = null
    private var foodRepository : FirebaseRepository =  FirebaseRepository()

    val text: LiveData<String> = _text

    init {
        foodListLiveData = foodRepository.getRecipes()
    }

   fun getData() : LiveData<List<FoodModel>>? {
       Log.d("TAG", "getData: Foodlist live data ${foodListLiveData?.value?.size}")
       return foodListLiveData
   }
}