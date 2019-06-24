package com.carlosdp.movalid.screen.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel: ViewModel(){

    //Encapsulation
    var _keyString = MutableLiveData<String>()
    val keyString : LiveData<String>
        get() = _keyString

    init {
        _keyString.value = ""
    }
}