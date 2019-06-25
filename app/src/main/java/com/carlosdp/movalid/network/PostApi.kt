package com.carlosdp.movalid.network

import com.carlosdp.movalid.model.ResponseApi
import com.carlosdp.movalid.utils.BASE_PARAMETERS
import com.carlosdp.movalid.utils.BASE_URL
import com.carlosdp.movalid.utils.VERSION
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap


private  val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private  val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface MovalidApiService {
    @GET("$VERSION/movie/popular$BASE_PARAMETERS")
    fun getFilmPopularOne():
            Deferred<ResponseApi>
//    fun getFilmPopular(@QueryMap options :Map<String, String> ): Observable<Response>
}

object MovalidApi {
    val retrofitService : MovalidApiService by lazy {
        retrofit.create(MovalidApiService::class.java)
    }
}