package com.carlosdp.movalid.network

import com.carlosdp.movalid.model.Response
import com.carlosdp.movalid.utils.BASE_PARAMETERS
import com.carlosdp.movalid.utils.VERSION
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface PostApi {
    @GET("$VERSION/movie/popular$BASE_PARAMETERS")
    fun getPosts(@QueryMap options :Map<String, String> ): Observable<Response>
}
