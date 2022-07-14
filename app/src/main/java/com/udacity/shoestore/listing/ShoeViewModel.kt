package com.udacity.shoestore.listing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    // encapsulated live data of list of shoes can only modified in this class
    private val _shoes = MutableLiveData<MutableList<Shoe>>().apply {
        value = mutableListOf()
    }

    val shoes = Transformations.map(_shoes) {
        it?.toList()
    }

    // encapsulated live data event used in navigation
    private val _navigateToDetailsEvent = MutableLiveData<Shoe?>()
    val navigateToDetailsEvent: LiveData<Shoe?> = _navigateToDetailsEvent

    // encapsulated live data event used in navigation
    private val _navigateToListing = MutableLiveData<Boolean?>()
    val navigateToListing: LiveData<Boolean?> = _navigateToListing

    fun navigateToDetailsScreen(shoe: Shoe) {
        _navigateToDetailsEvent.value = shoe
    }

    fun doneNavigating() {
        _navigateToDetailsEvent.value = null
        _navigateToListing.value = false
    }

    /**
     * cancel updating or adding a new item
     */
    fun cancel() {
        _navigateToListing.value = true
    }

    /**
     * save updating or adding a new item and notify the livedata
     */
    fun save(shoe: Shoe) {
        // safe !! as we added an empty list
        val shoes = _shoes.value!!
        // ids to check existence of a shoe
        val ids = shoes.map { it.id }

        if (ids.contains(shoe.id)) {
            // updating an existing shoe
            val index = shoes.first { it.id == shoe.id }.let {
                shoes.indexOf(shoe)
            }

            shoes[index] = shoe
        } else {
            // adding a new element
            shoes.add(shoe)
        }

        // submit an update to livedata
        _shoes.value = shoes

        // navigate back to listing
        _navigateToListing.value = true
    }
}