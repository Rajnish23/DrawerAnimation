package com.example.draweranimation.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{
        fun create() : ApiEndpoints {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://programming-quotes-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(ApiEndpoints::class.java)
        }
    }
}