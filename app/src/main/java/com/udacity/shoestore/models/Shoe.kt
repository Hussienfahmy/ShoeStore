package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlin.random.Random

@Parcelize
data class Shoe(
    val id: Int = Random.nextInt(),
    var name: String = "",
    var size: Double = 0.0,
    var company: String = "",
    var description: String = ""
) : Parcelable {
    companion object {
        @JvmStatic
        fun createNew() = Shoe()
    }
}