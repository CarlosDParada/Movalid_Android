package com.carlosdp.movalid.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel: ViewModel(){

    //Encapsulation
    var _film= MutableLiveData<String>()
    val filmShow : LiveData<String>
        get() = _film

    init {
        _film.value = ""
    }
}