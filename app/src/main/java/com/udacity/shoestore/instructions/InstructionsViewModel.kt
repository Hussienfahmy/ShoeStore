package com.udacity.shoestore.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel: ViewModel() {

    // encapsulated live data event used in navigation
    private val _navigateToListingScreenEvent = MutableLiveData<Boolean?>()
    val navigateTozListingScreenEvent: LiveData<Boolean?> = _navigateToListingScreenEvent

    fun navigateToInstructionsScreen() {
        _navigateToListingScreenEvent.value = true
    }

    fun doneNavigating() {
        _navigateToListingScreenEvent.value = false
    }
}