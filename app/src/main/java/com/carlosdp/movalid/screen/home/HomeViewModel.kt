package com.carlosdp.movalid.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel(){

    //Encapsulation
    var _movie = MutableLiveData<String>()
    val movie : LiveData<String>
        get() = _movie

    init {
        _movie.value = ""
    }
}