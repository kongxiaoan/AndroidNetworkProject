package com.kpa.androidnetworkproject.entry

import rx.functions.Func1


/**
 *author: mr.kong
 *Date:2018/10/29
 *description:
 *project name:AndroidNetworkProject
 **/
open class PayLoad<T>() : Func1<BaseResponse<T>, T> {

    override fun call(t: BaseResponse<T>?): T? {
        if (t != null) {
            if (!t.isSuccess()) {
                throw CusThrowable(t.status, t.message)
            }
        }
        return t?.data
    }


    @Suppress("INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS_WARNING")
    inner class CusThrowable(var status: Int, var message1: String) : Throwable()
}