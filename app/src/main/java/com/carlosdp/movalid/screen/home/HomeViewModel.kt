package com.carlosdp.movalid.screen.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carlosdp.movalid.model.Movie
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

class HomeViewModel : ViewModel() {

    //Encapsulation
    var _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    private val _properties = MutableLiveData<List<Movie>>()
    val properties: LiveData<List<Movie>>
        get() = _properties

    init {
        _message.value = ""
    }

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun getMoviePopular() {
        val url = BASE_URL + "/movie/popular$BASE_PARAMETERS"
        Log.i("Movalid", "URL Popular $url")

        coroutineScope.launch {
            var getMoviesPopularDeferred = MovalidApi.retrofitService.getFilmPopularOne()
            try {
                var listResult = getMoviesPopularDeferred.await()
                _properties.value = listResult.results

                _message.value = "Success: ${listResult.results?.size}"
                Log.i("Movalid", "${listResult.total_results}")

            } catch (t: Throwable) {
                _message.value = "Failure: " + t.message
            }
        }
    }


    fun getMovieTopRated() {
        coroutineScope.launch {
            var getMoviesPopularDeferred = MovalidApi.retrofitService.getFilmTopRatedOne()
            try {
                var listResult = getMoviesPopularDeferred.await()
                _properties.value = listResult.results

            } catch (t: Throwable) {
                _message.value = "Failure: " + t.message
            }
        }
    }

    fun getMovieUpComing() {

        coroutineScope.launch {
            var getMoviesPopularDeferred = MovalidApi.retrofitService.getFilmUpComingOne()
            try {
                var listResult = getMoviesPopularDeferred.await()
                _properties.value = listResult.results

            } catch (t: Throwable) {
                _message.value = "Failure: " + t.message
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}