package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    // encapsulated live data event used in navigation
    private val _navigateToWelcomeScreenEvent = MutableLiveData<Boolean?>()
    val navigateToWelcomeScreenEvent: LiveData<Boolean?> = _navigateToWelcomeScreenEvent

    fun navigateToWelcomeScreen() {
        _navigateToWelcomeScreenEvent.value = true
    }

    fun doneNavigating() {
        _navigateToWelcomeScreenEvent.value = false
    }
}