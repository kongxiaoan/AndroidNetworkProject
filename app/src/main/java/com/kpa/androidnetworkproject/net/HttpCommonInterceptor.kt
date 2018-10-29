package com.kpa.androidnetworkproject.net

import okhttp3.Interceptor
import okhttp3.Response

/**
 *author: mr.kong
 *Date:2018/10/29
 *description:
 *project name:AndroidNetworkProject
 **/
class HttpCommonInterceptor : Interceptor {
    private val mHeaderParamsMap = HashMap<String, String>()
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newBuilder = request.newBuilder()
        newBuilder.method(request.method(), request.body())

        if (mHeaderParamsMap.size > 0) {
            for (mutableEntry in mHeaderParamsMap) {
                newBuilder.header(mutableEntry.key, mutableEntry.value)
            }
        }
        val newRequest = newBuilder.build()
        return chain.proceed(newRequest)
    }

    constructor()

    inner class Builder {
        lateinit var mHttpCommonInterceptor: HttpCommonInterceptor

        fun addHeaderParams(key: String, value: String): Builder {
            mHttpCommonInterceptor.mHeaderParamsMap[key] = value
            return this
        }

        fun addHeaderParams(key: String, value: Int): Builder {
            return addHeaderParams(key, value.toString())
        }

        fun addHeaderParams(key: String, value: Float): Builder {
            return addHeaderParams(key, value.toString())
        }

        fun addHeaderParams(key: String, value: Long): Builder {
            return addHeaderParams(key, value.toString())
        }

        fun addHeaderParams(key: String, value: Double): Builder {
            return addHeaderParams(key, value.toString())
        }

        fun build(): HttpCommonInterceptor {
            return mHttpCommonInterceptor
        }


    }

}