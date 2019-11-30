package com.example.draweranimation.network

import com.example.draweranimation.data.Response
import io.reactivex.Single
import retrofit2.http.GET

interface ApiEndpoints {

    @GET("quotes")
    fun getQuotes() : Single<List<Response>>

}