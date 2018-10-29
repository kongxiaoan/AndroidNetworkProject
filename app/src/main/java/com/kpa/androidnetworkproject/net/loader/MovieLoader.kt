package com.kpa.androidnetworkproject.net.loader

import com.kpa.androidnetworkproject.entry.BaseResponse
import com.kpa.androidnetworkproject.entry.MovieSuject
import com.kpa.androidnetworkproject.entry.PayLoad
import com.kpa.androidnetworkproject.net.RetrofitServiceManager
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable



/**
 *author: mr.kong
 *Date:2018/10/29
 *description:
 *project name:AndroidNetworkProject
 **/
class MovieLoader : ObjectLoader() {
    fun getTap(start: Int): Observable<List<MovieSuject>> {
        val create = RetrofitServiceManager.create(MovieServices::class.java)
        return observe(create.getTap(start))
                .map(PayLoad<BaseResponse<List<MovieSuject>>>())

    }

    interface MovieServices {
        @GET("tap")
        fun getTap(@Query("start") start: Int): Observable<MovieSuject>
    }
}