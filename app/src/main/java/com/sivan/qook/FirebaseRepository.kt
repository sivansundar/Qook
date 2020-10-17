package com.sivan.qook

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.sivan.qook.model.FoodModel


class FirebaseRepository() {

    private val firestore : FirebaseFirestore = FirebaseFirestore.getInstance()
    val collectionReference : CollectionReference = firestore.collection("Recipes")

    private val foodListLiveData: MutableLiveData<List<FoodModel>> = MutableLiveData<List<FoodModel>>()


    fun getRecipes() : LiveData<List<FoodModel>> {

//        collectionReference.get().addOnCompleteListener {
//            if (it.isSuccessful) {
//                val item = it.result?.toObjects(FoodModel::class.java)
//                foodListLiveData.value = item;
//
//                Log.d("TAG", "getRecipes: ${item?.get(1)?.foodName}")
//            } else {
//                Log.d("Repository", "getProjectList: EXCEPTION : ${it.exception?.localizedMessage}")
//
//            }
//        }

        collectionReference.addSnapshotListener { querySnapshot, firebaseFirestoreException ->

            if (firebaseFirestoreException != null) {
                Log.d("Repository", "getProjectList: EXCEPTION : ${firebaseFirestoreException.localizedMessage}")

            } else {

                val item = querySnapshot?.toObjects(FoodModel::class.java)
                foodListLiveData.setValue(item);

                Log.d("TAG", "getRecipes: ${item?.get(1)?.foodName}")
            }

        }

        return foodListLiveData
    }

    }

