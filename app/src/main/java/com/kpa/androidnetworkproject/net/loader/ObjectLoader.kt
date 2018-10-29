package com.kpa.androidnetworkproject.net.loader

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 *author: mr.kong
 *Date:2018/10/29
 *description:
 *project name:AndroidNetworkProject
 **/
open class ObjectLoader {
    fun <T> observe(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}