package com.kpa.androidnetworkproject.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *author: mr.kong
 *Date:2018/10/29
 *description:
 *project name:AndroidNetworkProject
 **/
object RetrofitServiceManager {
    private const val DEFAULT_TIME_OUT = 5L //超时
    private const val DEFAULT_READ_TIME_OUT = 10L
    private lateinit var mRetrofit: Retrofit
    private val BASE_URL = ""

    init {
        val builder = OkHttpClient.Builder() //创建HttpClient
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS) //连接超时
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)

        //添加公共拦截器
        val interceptor = HttpCommonInterceptor().Builder()
                .addHeaderParams("", "").build()
        builder.addInterceptor(interceptor)
        //创建Retrofit
        mRetrofit = Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }

    /**
     * 创建对应的Service
     */
    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }

}