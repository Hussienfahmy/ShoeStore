package com.udacity.shoestore.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {

    private val _navigateToInstructionsScreenEvent = MutableLiveData<Boolean?>()
    val navigateToInstructionsScreenEvent: LiveData<Boolean?> = _navigateToInstructionsScreenEvent

    fun navigateToInstructionsScreen() {
        _navigateToInstructionsScreenEvent.value = true
    }

    fun doneNavigating() {
        _navigateToInstructionsScreenEvent.value = false
    }
}