package com.example.computerorder.data

import com.example.computerorder.data.api.GraphicCardApi
import com.example.computerorder.data.api.MonitorApi
import com.example.computerorder.data.api.OperationSystemApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://floral-cloud-1323.getsandbox.com"

    private val retrofit by lazy{

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val operationSystemApi: OperationSystemApi by lazy {
        retrofit.create(OperationSystemApi::class.java)
    }

    val graphicCardApi: GraphicCardApi by lazy {
        retrofit.create(GraphicCardApi::class.java)
    }

    val monitorApi: MonitorApi by lazy {
        retrofit.create(MonitorApi::class.java)
    }
}