package com.sivan.qook.model

import android.os.Parcel
import android.os.Parcelable

data class FoodModel(
    val foodID: String? = "",
    val foodName: String? = "",
    val foodDesc: String? = "",
    val foodType: List<String>? = emptyList<String>(),
    val foodImages: List<String>? = emptyList<String>(),
    val foodRating: Float? = 0.1253F,
    val foodIngredients : List<String>? = emptyList(),
    val foodDirections : List<String>? = emptyList(),
    val foodLikes: Int? = 1) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.createStringArrayList(),
            parcel.readValue(Float::class.java.classLoader) as? Float,
            parcel.createStringArrayList(),
            parcel.createStringArrayList(),
            parcel.readValue(Int::class.java.classLoader) as? Int) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(foodID)
        parcel.writeString(foodName)
        parcel.writeString(foodDesc)
        parcel.writeStringList(foodType)
        parcel.writeStringList(foodImages)
        parcel.writeValue(foodRating)
        parcel.writeStringList(foodIngredients)
        parcel.writeStringList(foodDirections)
        parcel.writeValue(foodLikes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FoodModel> {
        override fun createFromParcel(parcel: Parcel): FoodModel {
            return FoodModel(parcel)
        }

        override fun newArray(size: Int): Array<FoodModel?> {
            return arrayOfNulls(size)
        }
    }

}

