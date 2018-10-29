package com.kpa.androidnetworkproject.entry

/**
 *author: mr.kong
 *Date:2018/10/29
 *description:
 *project name:AndroidNetworkProject
 **/
class BaseResponse<T> {
    var status: Int = 0
    var message: String = ""
    var data: T? = null
    fun isSuccess(): Boolean {
        return status == 200
    }
}