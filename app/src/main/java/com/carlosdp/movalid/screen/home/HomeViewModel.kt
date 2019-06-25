package com.carlosdp.movalid.screen.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carlosdp.movalid.network.MovalidApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.carlosdp.movalid.model.ResponseApi
import com.carlosdp.movalid.utils.BASE_PARAMETERS
import com.carlosdp.movalid.utils.BASE_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel(){

    //Encapsulation
    var _message = MutableLiveData<String>()
    val message : LiveData<String>
        get() = _message

    private val _response = MutableLiveData<ResponseApi>()
    val response: LiveData<ResponseApi>
        get() = _response

    init {
        _message.value = ""
    }

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun getMoviePopular(){
        val url = BASE_URL +"/movie/popular$BASE_PARAMETERS"
        Log.i("Movalid", "URL Popular $url")

        coroutineScope.launch {
            MovalidApi.retrofitService.getFilmPopularOne().enqueue( object: Callback<ResponseApi> {
                override fun onFailure(call: Call<ResponseApi>, t: Throwable) {
                    _message.value = "Failure: " + t.message
                }
                override fun onResponse(call: Call<ResponseApi>, response: Response<ResponseApi>) {
                    Log.i("Movalid", "${response.body()?.total_results}")
                    _response.value = response.body()
                    _message.value = "Success: ${response.body()?.results?.size}"
                }
            })

        }


    }
}